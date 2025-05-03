package com.sout_rahim.quran_za.presentation.adapter

import android.graphics.Typeface
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sout_rahim.quran_za.data.model.SurahContentItem
import com.sout_rahim.quran_za.util.ArabConvertNumber
import com.sout_rahim.quran_za.util.Constants
import com.sout_rahim.quran_za.databinding.ItemAyahBookmarkBinding


class AyahBookmarkAdapter:RecyclerView.Adapter<AyahBookmarkAdapter.SurahViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<SurahContentItem>(){
        override fun areItemsTheSame(oldItem: SurahContentItem, newItem: SurahContentItem): Boolean {
            return oldItem.ID == newItem.ID
        }

        override fun areContentsTheSame(oldItem: SurahContentItem, newItem: SurahContentItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)
    private var fontSize: Float = 22f

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val binding = ItemAyahBookmarkBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val surahContentItem = differ.currentList[position]
        holder.bind(surahContentItem)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    // Method to update font size from ViewModel
    fun updateFontSize(fontSize: Float) {
        this.fontSize = fontSize
        notifyDataSetChanged()  // Notify adapter that the data set has changed and should be redrawn
    }

    inner class SurahViewHolder(
        val binding: ItemAyahBookmarkBinding
    ):
        RecyclerView.ViewHolder(binding.root){
        fun bind(surahContentItem: SurahContentItem){

            val ayahNumAr = getReversedArabicNumber(surahContentItem.VerseID.toString())
            var ayahText = surahContentItem.AyahText ?: ""

            // Remove Bismillah if it's the first ayah but not Surah Al-Fatiha
            ayahText = removeBismillahIfNeeded(surahContentItem, ayahText)

            // Format ayah text with verse number
            val formattedText = formatAyahText(surahContentItem, ayahText, ayahNumAr)

            // Apply formatted text to views
            binding.ayahText.text = formattedText
            binding.translateText.text = surahContentItem.AyahTextKhmer
            binding.surahText.text = "${Constants.SURAH_TEXT}${surahContentItem.SurahName}\t${Constants.AYAH_TEXT}"
            binding.extraText.text = "(${surahContentItem.VerseID})"
            applyCustomFonts(binding)

            // Set font size dynamically from the ViewModel
            binding.ayahText.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize)
            binding.translateText.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize - 6)
            binding.surahText.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize)
            binding.extraText.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize - 6)

            binding.btnAction.setOnClickListener {
                onBookmarkClickListener?.let {
                    it(surahContentItem)
                }
            }

            binding.layoutBookmark.setOnClickListener {
                onRootClickListener?.let {
                    it(surahContentItem)
                }
            }
        }
    }

    private fun getReversedArabicNumber(verseId: String): String {
        var arabicNumber = ArabConvertNumber(verseId).output

        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            arabicNumber.reversed()
        } else {
            arabicNumber
        }
    }
    private fun removeBismillahIfNeeded(item: SurahContentItem, ayah: String): String {
        return if (item.VerseID == 1 && item.SuraID != 1 && ayah.startsWith(Constants.BISMILLAH_TEXT)) {
            ayah.substring(Constants.BISMILLAH_TEXT.length)
        } else {
            ayah
        }
    }

    private fun formatAyahText(item: SurahContentItem, ayah: String, ayahNumAr: String): Spannable {
        return if (item.ID == Constants.ZERO) {
            SpannableString(ayah)
        } else {
            SpannableString("$ayah\t$ayahNumAr")
        }
    }

    private fun applyCustomFonts(binding: ItemAyahBookmarkBinding) {
        try {
            val fontUthmanic = Typeface.createFromAsset(binding.root.context.assets, "${Constants.FONT}/${Constants.UTHMANIC}")
            val fontKhmerOs = Typeface.createFromAsset(binding.root.context.assets, "${Constants.FONT}/${Constants.KHMEROS}")
            val fontTrado = Typeface.createFromAsset(binding.root.context.assets, "${Constants.FONT}/${Constants.TRADO}")

            binding.ayahText.typeface = fontUthmanic
            binding.translateText.typeface = fontKhmerOs
            binding.surahText.typeface = fontTrado
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private var onBookmarkClickListener: ((SurahContentItem) -> Unit)? = null
    private var onRootClickListener: ((SurahContentItem) -> Unit)? = null

    fun setOnBookmarkClickListener(listener: (SurahContentItem) -> Unit) {
        onBookmarkClickListener = listener
    }

    fun setOnRootClickListener(listener: (SurahContentItem) -> Unit) {
        onRootClickListener = listener
    }
}
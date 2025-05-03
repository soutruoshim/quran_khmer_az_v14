package com.sout_rahim.quran_za

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sout_rahim.quran_za.data.model.FavoriteItem
import com.sout_rahim.quran_za.databinding.BottomSheetDeleteBookmarkBinding
import com.sout_rahim.quran_za.databinding.FragmentBookmarkBinding
import com.sout_rahim.quran_za.presentation.adapter.AyahBookmarkAdapter
import com.sout_rahim.quran_za.presentation.viewmodel.QuranViewModel
import com.sout_rahim.quran_za.presentation.viewmodel.SettingViewModel
import com.sout_rahim.quran_za.util.Constants
import kotlinx.coroutines.launch

class BookmarkFragment : Fragment() {
    private lateinit var bookmarkFragmentBinding: FragmentBookmarkBinding
    private  lateinit var quranViewModel: QuranViewModel
    private lateinit var settingViewModel: SettingViewModel
    private lateinit var ayahBookmarkAdapter: AyahBookmarkAdapter
    private lateinit var bottomSheetDialog: BottomSheetDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        bookmarkFragmentBinding = FragmentBookmarkBinding.bind(view)

        quranViewModel= (activity as MainActivity).quranViewModel
        settingViewModel = (activity as MainActivity).settingViewModel

        bottomSheetDialog = BottomSheetDialog(requireContext())

        ayahBookmarkAdapter = (activity as MainActivity).ayahBookmarkAdapter
        ayahBookmarkAdapter.setOnBookmarkClickListener {
            val favoriteItem = FavoriteItem.fromSurahContentItem(it)
            quranViewModel.removeBookmark(favoriteItem)
            quranViewModel.fetchAllBookmarks()
            Toast.makeText(requireContext(), getString(R.string.bookmark_removed), Toast.LENGTH_SHORT).show()
        }

        ayahBookmarkAdapter.setOnRootClickListener {

            lifecycleScope.launch {
                val selectedSurah = it.SuraID?.let { id -> quranViewModel.getSurahById(id) }
                it.VerseID?.let { verseId -> quranViewModel.scrollToAyah(verseId) }

                Log.d(Constants.MYTAG, "Selected Surah: $selectedSurah")

                val bundle = Bundle().apply {
                    putSerializable(Constants.SELECTED_SURAH, selectedSurah)
                }
                findNavController().navigate(
                    R.id.action_bookmarkFragment_to_surahContentFragment,
                    bundle
                )
            }
        }

        initRecyclerView()
        viewBookmarkList()
        observeFontSize()
    }

    private fun showBottomSheet() {
        bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.NoOverlayDialog).apply {
            val binding = BottomSheetDeleteBookmarkBinding.inflate(LayoutInflater.from(context))
            setContentView(binding.root)

            with(binding) {
                btnCancel.setOnClickListener {
                    dismiss()
                }
                btnConfirm.setOnClickListener {
                   quranViewModel.removeAllBookmarks()
                   Toast.makeText(requireContext(), getString(R.string.bookmark_removed), Toast.LENGTH_SHORT).show()
                    dismiss()
                }
            }
        }
        bottomSheetDialog.show()
    }

    // This function observes the fontSize LiveData and updates the adapter whenever it changes.
    private fun observeFontSize() {
        settingViewModel.fontSize.observe(viewLifecycleOwner) { fontSize ->
            Log.d(Constants.MYTAG, "FontSize received in Activity Bookmark: $fontSize")
            // Check if fontSize is greater than 26, if so, do not update
            // If fontSize is greater than 26, set it to 26
            val finalFontSize = if (fontSize > 26) {
                26f  // Set to 26 if the font size is greater than 26
            } else {
                fontSize  // Use the received font size if it's less than or equal to 26
            }
            ayahBookmarkAdapter.updateFontSize(finalFontSize)
        }
    }

    private fun initRecyclerView() {
        val itemDecoration = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        bookmarkFragmentBinding.ayahBookmarkRecyclerView.apply {
            adapter = ayahBookmarkAdapter
            layoutManager = LinearLayoutManager(requireContext()) // Use requireContext() instead of activity
            addItemDecoration(itemDecoration) // Correct way to add item decoration
        }
    }

    private fun viewBookmarkList() {
        quranViewModel.fetchAllBookmarksContent()
        viewLifecycleOwner.lifecycleScope.launch {
            quranViewModel.surahBookmarkContent.collect { ayahs ->
                ayahBookmarkAdapter.differ.submitList(ayahs)
                Log.d(Constants.MYTAG, "Bookmark Received ${ayahs.size} bookmarked ayahs")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_bookmark_fragement, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_bookmark -> {
                showBottomSheet()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
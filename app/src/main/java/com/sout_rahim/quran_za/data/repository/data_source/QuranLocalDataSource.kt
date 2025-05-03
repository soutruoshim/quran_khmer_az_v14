package com.sout_rahim.quran_za.data.repository.data_source

import com.sout_rahim.quran_za.data.model.FavoriteItem
import com.sout_rahim.quran_za.data.model.SurahContentItem
import com.sout_rahim.quran_za.data.model.SurahItem
import kotlinx.coroutines.flow.Flow


interface QuranLocalDataSource {
    // Fetch all Surahs
    fun getAllSurahs(): Flow<List<SurahItem>>

    // Search Surahs by name or other criteria
    fun searchSurahs(query: String): Flow<List<SurahItem>>

    // Fetch content (Ayahs) of a specific Surah
    fun getSurahContent(surahId: Int): Flow<List<SurahContentItem>>

    // Search for a specific Ayah or phrase in Ayahs
    fun searchContent(query: String): Flow<List<SurahContentItem>>

    // Get a specific Ayah using Surah ID and Verse ID
    fun getAyahByIndex(surahId: Int, verseId: Int): Flow<SurahContentItem?>

    // Bookmark Management
    suspend fun addBookmark(favoriteItem: FavoriteItem)
    suspend fun removeBookmark(favoriteItem: FavoriteItem)
    suspend fun removeAllBookmarks()
    fun getAllBookmarks(): Flow<List<FavoriteItem>>
    fun getAllBookmarksAyahContent(): Flow<List<SurahContentItem>>
}
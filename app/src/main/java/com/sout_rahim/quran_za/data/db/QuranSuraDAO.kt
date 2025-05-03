package com.sout_rahim.quran_za.data.db

import androidx.room.Dao
import androidx.room.Query
import com.sout_rahim.quran_za.data.model.SurahItem
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranSuraDAO {
    @Query("SELECT * FROM QuranSura ORDER BY id ASC")
    fun getAllSurahs(): Flow<List<SurahItem>>  // Using Flow for real-time updates

    @Query("SELECT * FROM QuranSura WHERE id = :surahId OR name LIKE '%' || :surahName || '%'")
    fun searchSurah(surahId: Int?, surahName: String?): Flow<List<SurahItem>>  // Using Flow for reactivity
}
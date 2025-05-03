package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.SurahContentItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow

class GetAyahByIndexUseCase(private val repository: QuranRepository) {
    operator fun invoke(surahId: Int, verseId: Int): Flow<SurahContentItem> {
        return repository.getAyahByIndex(surahId, verseId)
    }
}
package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.SurahContentItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow

class GetSurahContentUseCase(private val repository: QuranRepository) {
    operator fun invoke(surahId: Int): Flow<List<SurahContentItem>> {
        return repository.getSurahContent(surahId)
    }
}
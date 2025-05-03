package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.SurahItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow

class GetSearchSurahUseCase(private val repository: QuranRepository) {
    operator fun invoke(query: String): Flow<List<SurahItem>> {
        return repository.searchSurahs(query)
    }
}
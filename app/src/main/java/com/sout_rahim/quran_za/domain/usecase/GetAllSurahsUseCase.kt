package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.SurahItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow

class GetAllSurahsUseCase(private val repository: QuranRepository) {
    operator fun invoke(): Flow<List<SurahItem>> {
        return repository.getAllSurahs()
    }
}


package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.SurahContentItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow

class GetAllBookmarksContentUseCase(private val repository: QuranRepository) {
    operator fun invoke(): Flow<List<SurahContentItem>> {
        return repository.getAllBookmarksAyahContent()
    }
}
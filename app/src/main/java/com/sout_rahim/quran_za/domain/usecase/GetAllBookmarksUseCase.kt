package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.FavoriteItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import kotlinx.coroutines.flow.Flow

class GetAllBookmarksUseCase(private val repository: QuranRepository) {
    operator fun invoke(): Flow<List<FavoriteItem>> {
        return repository.getAllBookmarks()
    }
}
package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.data.model.FavoriteItem
import com.sout_rahim.quran_za.domain.repository.QuranRepository

class RemoveBookmarkUseCase(private val repository: QuranRepository) {
    suspend operator fun invoke(favoriteItem: FavoriteItem) {
        repository.removeBookmark(favoriteItem)
    }
}
package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.domain.repository.QuranRepository

class RemoveAllBookmarksUseCase(private val repository: QuranRepository) {
    suspend operator fun invoke() {
        repository.removeAllBookmarks()
    }
}
package com.sout_rahim.quran_za.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sout_rahim.quran_za.domain.usecase.AddBookmarkUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAllBookmarksContentUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAllBookmarksUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAllSurahsUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAyahByIndexUseCase
import com.sout_rahim.quran_za.domain.usecase.GetSearchContentUseCase
import com.sout_rahim.quran_za.domain.usecase.GetSearchSurahUseCase
import com.sout_rahim.quran_za.domain.usecase.GetSurahContentUseCase
import com.sout_rahim.quran_za.domain.usecase.RemoveAllBookmarksUseCase
import com.sout_rahim.quran_za.domain.usecase.RemoveBookmarkUseCase

class QuranViewModelFactory(
    private val getAllSurahsUseCase: GetAllSurahsUseCase,
    private val getSearchSurahUseCase: GetSearchSurahUseCase,
    private val getSurahContentUseCase: GetSurahContentUseCase,
    private val getSearchContentUseCase: GetSearchContentUseCase,
    private val getAyahByIndexUseCase: GetAyahByIndexUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val getAllBookmarksUseCase: GetAllBookmarksUseCase,
    private val removeBookmarkUseCase: RemoveBookmarkUseCase,
    private val removeAllBookmarksUseCase: RemoveAllBookmarksUseCase,
    private val getAllBookmarksContentUseCase: GetAllBookmarksContentUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuranViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuranViewModel(
                getAllSurahsUseCase,
                getSearchSurahUseCase,
                getSurahContentUseCase,
                getSearchContentUseCase,
                getAyahByIndexUseCase,
                addBookmarkUseCase,
                getAllBookmarksUseCase,
                removeBookmarkUseCase,
                removeAllBookmarksUseCase,
                getAllBookmarksContentUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
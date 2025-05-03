package com.sout_rahim.quran_za.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sout_rahim.quran_za.domain.usecase.GetAvailableLanguagesUseCase
import com.sout_rahim.quran_za.domain.usecase.GetCurrentLanguageUseCase
import com.sout_rahim.quran_za.domain.usecase.GetDarkModeUseCase
import com.sout_rahim.quran_za.domain.usecase.GetFontSizeUseCase
import com.sout_rahim.quran_za.domain.usecase.SaveDarkModeUseCase
import com.sout_rahim.quran_za.domain.usecase.SaveFontSizeUseCase
import com.sout_rahim.quran_za.domain.usecase.SaveLanguageUseCase

class SettingViewModelFactory(
    private val getAvailableLanguagesUseCase: GetAvailableLanguagesUseCase,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase,
    private val saveLanguageUseCase: SaveLanguageUseCase,
    private val getFontSizeUseCase: GetFontSizeUseCase,
    private val saveFontSizeUseCase: SaveFontSizeUseCase,
    private val saveDarkModeUseCase: SaveDarkModeUseCase,
    private val getDarkModeUseCase: GetDarkModeUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(
                getAvailableLanguagesUseCase,
                getCurrentLanguageUseCase,
                saveLanguageUseCase,
                getFontSizeUseCase,
                saveFontSizeUseCase,
                saveDarkModeUseCase,
                getDarkModeUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
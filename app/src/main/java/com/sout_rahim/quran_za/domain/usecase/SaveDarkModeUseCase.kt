package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.domain.repository.SettingRepository

class SaveDarkModeUseCase(private val repository: SettingRepository) {
    operator fun invoke(isDarkMode: Boolean) {
        // Save the dark mode setting in the repository
        repository.saveDarkMode(isDarkMode)
    }
}
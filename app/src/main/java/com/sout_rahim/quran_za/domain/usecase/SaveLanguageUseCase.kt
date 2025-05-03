package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.domain.repository.SettingRepository

class SaveLanguageUseCase(private val repository: SettingRepository) {
    operator fun invoke(lang: String) {
        repository.saveLanguage(lang)
    }
}
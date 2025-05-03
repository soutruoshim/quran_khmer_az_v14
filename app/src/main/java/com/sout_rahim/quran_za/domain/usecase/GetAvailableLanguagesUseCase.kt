package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.domain.repository.SettingRepository

class GetAvailableLanguagesUseCase(private val repository: SettingRepository) {
    operator fun invoke() = repository.getLanguages()
}
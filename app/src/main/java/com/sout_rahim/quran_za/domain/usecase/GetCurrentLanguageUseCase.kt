package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.domain.repository.SettingRepository

class GetCurrentLanguageUseCase(private val repository: SettingRepository) {
    operator fun invoke(): String = repository.getCurrentLanguage()
}
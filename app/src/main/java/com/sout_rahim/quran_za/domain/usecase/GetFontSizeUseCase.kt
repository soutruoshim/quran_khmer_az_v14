package com.sout_rahim.quran_za.domain.usecase

import com.sout_rahim.quran_za.domain.repository.SettingRepository

class GetFontSizeUseCase(private val repository: SettingRepository) {
    operator fun invoke() = repository.getFontSize()
}
package com.sout_rahim.quran_za.presentation.di

import com.sout_rahim.quran_za.domain.repository.QuranRepository
import com.sout_rahim.quran_za.domain.repository.SettingRepository
import com.sout_rahim.quran_za.domain.usecase.AddBookmarkUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAllBookmarksContentUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAllBookmarksUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAllSurahsUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAvailableLanguagesUseCase
import com.sout_rahim.quran_za.domain.usecase.GetAyahByIndexUseCase
import com.sout_rahim.quran_za.domain.usecase.GetCurrentLanguageUseCase
import com.sout_rahim.quran_za.domain.usecase.GetDarkModeUseCase
import com.sout_rahim.quran_za.domain.usecase.GetFontSizeUseCase
import com.sout_rahim.quran_za.domain.usecase.GetSearchContentUseCase
import com.sout_rahim.quran_za.domain.usecase.GetSearchSurahUseCase
import com.sout_rahim.quran_za.domain.usecase.GetSurahContentUseCase
import com.sout_rahim.quran_za.domain.usecase.RemoveAllBookmarksUseCase
import com.sout_rahim.quran_za.domain.usecase.RemoveBookmarkUseCase
import com.sout_rahim.quran_za.domain.usecase.SaveDarkModeUseCase
import com.sout_rahim.quran_za.domain.usecase.SaveFontSizeUseCase
import com.sout_rahim.quran_za.domain.usecase.SaveLanguageUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Provides
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideAddBookmarkUseCase(repository: QuranRepository): AddBookmarkUseCase {
        return AddBookmarkUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAllBookmarksUseCase(repository: QuranRepository): GetAllBookmarksUseCase {
        return GetAllBookmarksUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAllSurahsUseCase(repository: QuranRepository): GetAllSurahsUseCase {
        return GetAllSurahsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAyahByIndexUseCase(repository: QuranRepository): GetAyahByIndexUseCase {
        return GetAyahByIndexUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetSearchContentUseCase(repository: QuranRepository): GetSearchContentUseCase {
        return GetSearchContentUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetSearchSurahUseCase(repository: QuranRepository): GetSearchSurahUseCase {
        return GetSearchSurahUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetSurahContentUseCase(repository: QuranRepository): GetSurahContentUseCase {
        return GetSurahContentUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideRemoveAllBookmarksUseCase(repository: QuranRepository): RemoveAllBookmarksUseCase {
        return RemoveAllBookmarksUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideRemoveBookmarkUseCase(repository: QuranRepository): RemoveBookmarkUseCase {
        return RemoveBookmarkUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAllBookmarksContentUseCase(repository: QuranRepository): GetAllBookmarksContentUseCase {
        return GetAllBookmarksContentUseCase(repository)
    }


    @Singleton
    @Provides
    fun provideGetAvailableLanguagesUseCase(
        repository: SettingRepository
    ): GetAvailableLanguagesUseCase {
        return GetAvailableLanguagesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetCurrentLanguageUseCase(
        repository: SettingRepository
    ): GetCurrentLanguageUseCase {
        return GetCurrentLanguageUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSaveLanguageUseCase(
        repository: SettingRepository
    ): SaveLanguageUseCase {
        return SaveLanguageUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetFontSizeUseCase(
        repository: SettingRepository
    ): GetFontSizeUseCase {
        return GetFontSizeUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSaveFontSizeUseCase(
        repository: SettingRepository
    ): SaveFontSizeUseCase {
        return SaveFontSizeUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetDarkModeUseCase(
        repository: SettingRepository
    ): GetDarkModeUseCase {
        return GetDarkModeUseCase(repository)
    }

    // Provide SaveDarkModeUseCase
    @Singleton
    @Provides
    fun provideSaveDarkModeUseCase(
        repository: SettingRepository
    ): SaveDarkModeUseCase {
        return SaveDarkModeUseCase(repository)
    }
}
package com.sout_rahim.quran_za.presentation.di

import com.sout_rahim.quran_za.data.repository.QuranRepositoryImpl
import com.sout_rahim.quran_za.data.repository.SettingRepositoryImpl
import com.sout_rahim.quran_za.data.repository.data_source.QuranLocalDataSource
import com.sout_rahim.quran_za.data.repository.data_source.SharedPrefManager
import com.sout_rahim.quran_za.domain.repository.QuranRepository
import com.sout_rahim.quran_za.domain.repository.SettingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideQuranRepository(
        quranLocalDataSource: QuranLocalDataSource
    ): QuranRepository {
        return QuranRepositoryImpl(quranLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideSettingRepository(
        sharedPrefManager: SharedPrefManager
    ): SettingRepository {
        return SettingRepositoryImpl(sharedPrefManager)
    }
}
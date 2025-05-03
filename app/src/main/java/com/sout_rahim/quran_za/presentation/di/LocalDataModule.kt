package com.sout_rahim.quran_za.presentation.di

import com.sout_rahim.quran_za.data.db.FavoriteDAO
import com.sout_rahim.quran_za.data.db.QuranAyahDAO
import com.sout_rahim.quran_za.data.db.QuranSuraDAO
import com.sout_rahim.quran_za.data.repository.data_source.QuranLocalDataSource
import com.sout_rahim.quran_za.data.repository.data_source_impl.QuranLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideQuranLocalDataSource(
        quranAyahDAO: QuranAyahDAO,
        quranSuraDAO: QuranSuraDAO,
        favoriteDAO: FavoriteDAO
    ): QuranLocalDataSource {
        return QuranLocalDataSourceImpl(quranAyahDAO, quranSuraDAO, favoriteDAO)
    }
}
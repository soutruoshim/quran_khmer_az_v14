package com.sout_rahim.quran_za.presentation.di

import com.sout_rahim.quran_za.presentation.adapter.AyahAdapter
import com.sout_rahim.quran_za.presentation.adapter.AyahBookmarkAdapter
import com.sout_rahim.quran_za.presentation.adapter.MixedAdapter
import com.sout_rahim.quran_za.presentation.adapter.SurahAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideSurahAdapter(): SurahAdapter {
        return SurahAdapter()
    }

    @Singleton
    @Provides
    fun provideAyahAdapter(): AyahAdapter {
        return AyahAdapter()
    }

    @Singleton
    @Provides
    fun provideAyahBookmarkAdapter(): AyahBookmarkAdapter {
        return AyahBookmarkAdapter()
    }

    @Singleton
    @Provides
    fun provideMixAdapter(): MixedAdapter {
        return MixedAdapter()
    }
}
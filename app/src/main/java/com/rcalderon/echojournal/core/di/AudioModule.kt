package com.rcalderon.echojournal.core.di

import android.media.MediaPlayer
import com.rcalderon.echojournal.core.application.audio_manager.DefaultAudioManager
import com.rcalderon.echojournal.core.repositories.AudioManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AudioModule {

    @Provides
    @Singleton
    fun provideMediaPlayer(): MediaPlayer {
        return MediaPlayer()
    }

    @Provides
    @Singleton
    fun provideAudioManager(mediaPlayer: MediaPlayer): AudioManager {
        return DefaultAudioManager(mediaPlayer)
    }
}
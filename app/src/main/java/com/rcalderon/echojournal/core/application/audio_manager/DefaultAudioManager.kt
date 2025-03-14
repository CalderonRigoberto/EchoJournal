package com.rcalderon.echojournal.core.application.audio_manager

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import com.rcalderon.echojournal.core.repositories.AudioManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit


class DefaultAudioManager(
    private val mediaPlayer: MediaPlayer
) : AudioManager {

    override suspend fun playAudio(source: Uri) {
        withContext(SupervisorJob() + Dispatchers.Default) {
            mediaPlayer.setDataSource(source.toString())
            mediaPlayer.prepare()
            mediaPlayer.start()
        }
    }

    override suspend fun isPLaying(): Boolean {
        return withContext(Dispatchers.Default) {
            mediaPlayer.isPlaying
        }
    }

    override suspend fun pauseAudio() {
        withContext(Dispatchers.Default) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        }
    }

    override fun getPlaybackTimeFlow(updateIntervalMs: Long): Flow<Float> = flow {
        while (mediaPlayer.isPlaying) {
            val duration = mediaPlayer.duration
            val position = mediaPlayer.currentPosition
            val progress = if (duration > 0) position.toFloat() / duration else 0f
            emit(progress)
            delay(updateIntervalMs)
        }
    }
}
package com.rcalderon.echojournal.core.repositories

import android.net.Uri
import kotlinx.coroutines.flow.Flow

interface AudioManager {

    suspend fun playAudio(source: Uri)

    suspend fun isPLaying(): Boolean

    suspend fun pauseAudio()

    fun getPlaybackTimeFlow(updateIntervalMs: Long = 1000) : Flow<Float>
}
package com.rcalderon.echojournal.presentation.entries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rcalderon.echojournal.core.repositories.AudioManager
import com.rcalderon.echojournal.presentation.entries.components._fakeEntries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class EntriesViewModel @Inject constructor(
    private val audioManager: AudioManager
) : ViewModel() {

    private val _state = MutableStateFlow<EntriesScreenState>(EntriesScreenState(entries = _fakeEntries))
    val state: StateFlow<EntriesScreenState> = _state

    private val _playbackTimeState = MutableStateFlow<Float?>(null)
    val playbackTimeState: StateFlow<Float?> = _playbackTimeState

    private val _playbackFormattedTimeState = MutableStateFlow<String>("0:00")
    val playbackFormattedTimeState: StateFlow<String> = _playbackFormattedTimeState

    fun onEvent(event: EntriesScreenEvents) {
        when(event) {
           is EntriesScreenEvents.PLayAudio -> {
               viewModelScope.launch {
                   if(audioManager.isPLaying()) {
                       audioManager.pauseAudio()
                       _playbackTimeState.value = 0f
                       _state.value = _state.value.copy(isPlaying = false)
                       return@launch
                   }

                   _state.update { it.copy(isPlaying = true) }
                   audioManager.playAudio(event.source)
                   audioManager.getPlaybackTimeFlow()
                       .collect {
                           _playbackTimeState.value = it

                           // TODO Format time
                           _playbackFormattedTimeState.value = it.toString()
                       }

               }
            }
            else -> {

            }
        }
    }
}
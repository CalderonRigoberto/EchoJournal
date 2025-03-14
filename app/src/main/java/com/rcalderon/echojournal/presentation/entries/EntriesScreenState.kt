package com.rcalderon.echojournal.presentation.entries

import com.rcalderon.echojournal.core.data.model.EntryUiModel

data class EntriesScreenState(
    val entries: List<EntryUiModel> = emptyList(),
    val isRecordingNewEntry: Boolean = false,
    val currentEntryOnPlay: EntryUiModel? = null,
    val isPlaying: Boolean = false,
)

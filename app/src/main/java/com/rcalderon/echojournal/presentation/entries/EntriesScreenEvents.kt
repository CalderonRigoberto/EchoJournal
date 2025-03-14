package com.rcalderon.echojournal.presentation.entries

import android.net.Uri

sealed class EntriesScreenEvents {
    data class PLayAudio(val source: Uri) : EntriesScreenEvents()
}
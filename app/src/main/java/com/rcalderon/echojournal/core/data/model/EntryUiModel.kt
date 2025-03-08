package com.rcalderon.echojournal.core.data.model

import android.net.Uri
import com.rcalderon.echojournal.presentation.enums.Mood

data class EntryUiModel(
    val title: String,
    val description: String?,
    val topics: List<TopicUiModel>,
    val source: Uri,
    val createdAt: String,
    val mood: Mood = Mood.Neutral
)

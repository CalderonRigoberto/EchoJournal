package com.rcalderon.echojournal.core.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Topic(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: Boolean = true
)

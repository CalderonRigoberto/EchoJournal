package com.rcalderon.echojournal.core.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Entrie(
    @PrimaryKey
    val id: Int,
    val title: String,
    @ColumnInfo(name = "record_path")
    val recordPath: String,
    @ColumnInfo(name = "mood_id")
    val moodId: Int,
    @ColumnInfo(name = "time_in_seconds")
    val timeInSeconds: Int,
    @ColumnInfo(typeAffinity = ColumnInfo.REAL)
    val size: Float,
    val description: String?,
    @ColumnInfo(name = "created_at")
    val createdAt: LocalDateTime,
    @ColumnInfo(name = "updated_at")
    val updatedAt: LocalDateTime,
    val status: Boolean = true
)

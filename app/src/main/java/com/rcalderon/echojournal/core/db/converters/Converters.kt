package com.rcalderon.echojournal.core.db.converters

import android.R.attr
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId


class Converters {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        return LocalDateTime.ofInstant(
            Instant.ofEpochMilli(attr.value.toLong()),
            ZoneId.systemDefault()
        )

    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun localDateToString(value: LocalDateTime?) : Long? {
        return value?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    }
}
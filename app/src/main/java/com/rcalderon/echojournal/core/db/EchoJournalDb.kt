package com.rcalderon.echojournal.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rcalderon.echojournal.core.db.converters.Converters
import com.rcalderon.echojournal.core.db.dao.EntrieDao
import com.rcalderon.echojournal.core.db.dao.TopicDao
import com.rcalderon.echojournal.core.db.model.Entrie
import com.rcalderon.echojournal.core.db.model.Topic

@Database(
    entities = [Entrie::class, Topic::class],
    version = 1
)
@TypeConverters(value = [Converters::class])
abstract class EchoJournalDb : RoomDatabase(){
    abstract fun topicDao() : TopicDao
    abstract fun entrieDao() : EntrieDao
}
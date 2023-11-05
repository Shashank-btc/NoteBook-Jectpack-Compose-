package com.example.noteappdemojectpack.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    var id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    var title: String,

    @ColumnInfo(name = "note_desc")
    var desc: String,

    @ColumnInfo(name = "note_data")
//    var enteryDate: LocalDateTime = LocalDateTime.now()
    var enteryDate: Date =Date.from(Instant.now())
)

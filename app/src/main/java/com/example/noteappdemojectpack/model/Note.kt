package com.example.noteappdemojectpack.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*

data class Note(
    var id: UUID = UUID.randomUUID(),
    var title: String,
    var desc: String,
    var enteryDate: LocalDateTime = LocalDateTime.now()
)

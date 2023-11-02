package com.example.noteappdemojectpack.data

import androidx.compose.runtime.*
import com.example.noteappdemojectpack.model.Note

class NoteDataSource{
    fun loadNotes() : List<Note>{
        return  listOf(
            Note(title = "hi", desc = "please fill time sheet"),
            Note(title = "hi2", desc = "please fill time sheet"),
            Note(title = "hi3", desc = "please fill time sheet"),
            Note(title = "hi4", desc = "please fill time sheet"),
            Note(title = "hi5", desc = "please fill time sheet"),
            Note(title = "hi6", desc = "please fill time sheet"),
            Note(title = "hi7", desc = "please fill time sheet"),
            Note(title = "hi8", desc = "please fill time sheet"),
            Note(title = "hi9", desc = "please fill time sheet"),
            Note(title = "hi10", desc = "please fill time sheet"),
        )
    }
    fun AddNote(note :Note){

    }
}


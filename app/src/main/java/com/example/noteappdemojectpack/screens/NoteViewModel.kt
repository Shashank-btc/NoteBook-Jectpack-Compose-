package com.example.noteappdemojectpack.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import com.example.noteappdemojectpack.data.NoteDataSource
import com.example.noteappdemojectpack.model.Note

class NoteViewModel : ViewModel() {

    var noteList = mutableStateListOf<Note>()

    init{
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note :Note){
        noteList.add(note)
    }
    fun removeNote(note :Note){
        noteList.remove(note)
    }
    fun getAllNote() :List<Note>{
        return noteList
    }
}
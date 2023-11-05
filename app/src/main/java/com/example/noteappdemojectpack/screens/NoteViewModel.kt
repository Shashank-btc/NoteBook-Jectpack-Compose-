package com.example.noteappdemojectpack.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.noteappdemojectpack.data.NoteDataSource
import com.example.noteappdemojectpack.model.Note
import com.example.noteappdemojectpack.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository : NoteRepository) : ViewModel() {

//    var noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())

    val noteList = _noteList.asStateFlow()

    init{
//        noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect{
                    listOfNotes ->
                    if(listOfNotes.isNullOrEmpty()){
                        Log.e("check","emplty")
                    } else{
                        _noteList.value = listOfNotes
                    }
                }}
    }

     fun addNote(note :Note) = viewModelScope.launch { repository.addNote(note) }
     fun updateNote(note :Note) = viewModelScope.launch { repository.updateNote(note) }
     fun deleteNote(note :Note) = viewModelScope.launch { repository.deleteNote(note) }
     fun deleteAll() = viewModelScope.launch { repository.deleteAllNotes() }

}
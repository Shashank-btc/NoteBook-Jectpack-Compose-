package com.example.noteappdemojectpack.repository

import com.example.noteappdemojectpack.data.NoteDatabaseDao
import com.example.noteappdemojectpack.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note :Note)  = noteDatabaseDao.inset(note)
    suspend fun updateNote(note :Note)  = noteDatabaseDao.update(note)
    suspend fun deleteNote(note :Note)  = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNotes()  = noteDatabaseDao.deleteAll()

    fun getAllNotes() : Flow<List<Note>> = noteDatabaseDao.getListofNotes().flowOn(Dispatchers.IO)
        .conflate()

}
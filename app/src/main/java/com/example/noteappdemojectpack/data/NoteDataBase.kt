package com.example.noteappdemojectpack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.noteappdemojectpack.model.Note
import com.example.noteappdemojectpack.util.DateConverter


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao() : NoteDatabaseDao
}
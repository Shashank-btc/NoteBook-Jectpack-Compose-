package com.example.noteappdemojectpack.di

import android.content.Context
import androidx.room.Room
import com.example.noteappdemojectpack.data.NoteDataBase
import com.example.noteappdemojectpack.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModuel {

    @Singleton
    @Provides
    fun providerNoteDao(noteDatabase : NoteDataBase) : NoteDatabaseDao
    = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context : Context) : NoteDataBase
    = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        name = "notes_db"
    ).fallbackToDestructiveMigration()
        .build()
}
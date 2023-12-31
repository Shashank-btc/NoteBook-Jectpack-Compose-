package com.example.noteappdemojectpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteappdemojectpack.model.Note
import com.example.noteappdemojectpack.screens.NoteScreen
import com.example.noteappdemojectpack.screens.NoteViewModel
import com.example.noteappdemojectpack.ui.theme.NoteAppDemoJectPackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    NoteAppDemoJectPackTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun MainContent() {
    val noreViewModel = viewModel<NoteViewModel>()
    ShowNoteData(noreViewModel)
}

@Composable
fun ShowNoteData(noteViewModel : NoteViewModel = viewModel()){

    NoteScreen(notes = noteViewModel.noteList.collectAsState().value,
        onAddNote = {
            noteViewModel.addNote(it)
    }, onRemove = {
        noteViewModel.deleteNote(it)
    })
}

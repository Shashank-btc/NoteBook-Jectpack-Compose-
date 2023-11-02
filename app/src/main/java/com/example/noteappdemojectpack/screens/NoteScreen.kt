package com.example.noteappdemojectpack.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteappdemojectpack.R
import com.example.noteappdemojectpack.components.EditTextFild
import com.example.noteappdemojectpack.components.NoteButton
import com.example.noteappdemojectpack.data.NoteDataSource
import com.example.noteappdemojectpack.model.Note
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemove: (Note) -> Unit
) {
    var title by remember{ mutableStateOf("") }
    var desc by remember{ mutableStateOf("") }
    var contect = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)) {
       TopAppBar(title = { Text(text = stringResource(id = R.string.app_name))},
       actions = {
           Icon(imageVector = Icons.Rounded.Notifications, contentDescription ="icon" )
       },
       colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
           containerColor =  Color(0xFFDCEFF8)
       ), navigationIcon = {


           Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="",
           modifier = Modifier.clickable {
               Log.e("checl","back arrow clicked")
           })
           })
        Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

            EditTextFild(text = title, lable = "title", onTextChange = {
                if(it.all{
                            char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
            })
            EditTextFild(text = desc, lable = "Add note", onTextChange = {
                if(it.all{
                            char ->
                        char.isLetter() || char.isWhitespace()
                    }) desc = it
            })
            Spacer(modifier = Modifier.padding(10.dp))
            NoteButton(text = "save", onClick = {
                if(title.isNotEmpty() && desc.isNotEmpty()){
                    onAddNote(Note(title= title, desc = desc))
                    title = ""
                    desc = ""
                    Toast.makeText(contect, "Note added", Toast.LENGTH_SHORT).show()
                }
//                else {
//                    onRemove(notes.last())
//                }
            })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn(){
            items(notes){
                note -> NoteRow(note = note, onNoteClicked = {
                    onRemove(it)
            })
            }
        }

    }
}
@Composable
fun NoteRow(modifier: Modifier= Modifier,
            note :Note,
            onNoteClicked :(Note) -> Unit){
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 6.dp) {
        Column(
            modifier
                .clickable {onNoteClicked(note) }
                .padding(14.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.labelMedium)
            Text(text = note.desc, style = MaterialTheme.typography.labelSmall)
            Text(text = note.enteryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.bodyLarge)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun NotesScreenPrivew() {
    NoteScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemove = {})
}
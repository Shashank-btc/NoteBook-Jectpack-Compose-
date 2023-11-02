package com.example.noteappdemojectpack.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun EditTextFild(
    modifier: Modifier = Modifier,
    text : String,
    maxLine :Int = 1,
    singleLine : Boolean =false,
    lable :String,
onTextChange : (String) -> Unit,
onImeAction: () -> Unit = {}){
    var textfield by remember{ mutableStateOf("") }
    var keyboardController = LocalSoftwareKeyboardController.current

    TextField(value = text, onValueChange = onTextChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(disabledBorderColor = Color.Transparent),
    maxLines = maxLine,
    label = { Text(text = lable)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )

}
@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text : String,
    onClick: () -> Unit,
    enable : Boolean = true
){
    Button(onClick = onClick, shape = CircleShape,
    enabled = enable,
    modifier = modifier) {
        Text(text = text)
    }

}
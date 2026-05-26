package `in`.tanuj.state.jetpackcompose_5.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import `in`.tanuj.state.jetpackcompose_5.vm.StateTestViewModel

@Composable
fun StateTestScreen(modifier: Modifier = Modifier, viewModel: StateTestViewModel) {
    Log.i("MyScreenLog","screen")

    // this will save the value even if screen rotates
//    var name by rememberSaveable {
//        mutableStateOf("")
//    }

    //
//    var name by remember {
//        mutableStateOf("")
//    }

    //via view Model and and handles data in configuration change.
    val name by viewModel.name.observeAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText(modifier, name)
        MyTextField(modifier, name, onNameChange = {
            viewModel.onNameUpdate(it)
        })
    }
}

@Composable
fun MyText(modifier: Modifier = Modifier, name: String?) {
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(modifier: Modifier = Modifier, name: String, onNameChange: (String) -> Unit) {

    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = { Text(text = "Enter name") })
}


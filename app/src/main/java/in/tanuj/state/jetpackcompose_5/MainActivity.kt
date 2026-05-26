package `in`.tanuj.state.jetpackcompose_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import `in`.tanuj.state.jetpackcompose_5.ui.theme.JetPackCompose_5Theme
import `in`.tanuj.state.jetpackcompose_5.ui.view.StateTestScreen
import `in`.tanuj.state.jetpackcompose_5.vm.StateTestViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[StateTestViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            JetPackCompose_5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StateTestScreen(
                        modifier = Modifier.padding(innerPadding), viewModel
                    )
                }
            }
        }
    }
}

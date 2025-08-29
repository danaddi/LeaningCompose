package com.example.leaningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.leaningcompose.ui.theme.LeaningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeaningComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // здесь мы будем хранить состояние (введённый текст)
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GreetingImage()
        GreetingMessage(name = "Dana")
        UserInput(text = text, onTextChange = { text = it })
        DisplayText(text = text)
    }
}

@Composable
fun GreetingImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_action_name),
        contentDescription = "Android waving",
        modifier = Modifier.size(100.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun GreetingMessage(name: String) {
    Row {
        Text(text = "Hello ")
        Text(text = name)
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun UserInput(text: String, onTextChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}

@Composable
fun DisplayText(text: String) {
    Text(text = "Вы ввели: $text")
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LeaningComposeTheme {
        MainScreen()
    }
}

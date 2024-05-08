package com.example.testbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testbutton.ui.theme.TestButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    var userInput by remember { mutableStateOf("") }
    var userOutput by remember { mutableStateOf(userInput) }
    Column(modifier = Modifier
        .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "Test Button",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        Spacer(modifier = Modifier.height(20.dp))

        EditTextField(
            value = userInput,
            onValueChange = { userInput = it },
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth())

        Button(onClick = { userOutput = userInput }) {
            Text(stringResource(R.string.show_output))
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Here is your output: ",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 20.dp)
                .align(alignment = Alignment.Start)
        )
        Text(
            text = userOutput,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(bottom = 160.dp, top = 20.dp)
                .align(alignment = Alignment.Start)

        )

    }
}

@Composable
fun EditTextField(value: String,
                  onValueChange: (String) -> Unit,
                  modifier: Modifier = Modifier) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {Text(stringResource(R.string.type_something))},
        singleLine = true,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestButtonTheme {
        Greeting()
    }
}
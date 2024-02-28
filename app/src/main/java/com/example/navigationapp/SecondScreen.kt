package com.example.navigationapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen(){
    val name  = remember{ mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp,),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "This is Second Screen",
            modifier = Modifier,

            fontSize = 16.sp,
            // Specify other parameters as needed
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome",)
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Go to First Screen")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen()
}
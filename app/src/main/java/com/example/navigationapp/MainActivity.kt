package com.example.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                      MyApp()
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navigationToSecondScreen:() -> Unit){
    val name  = remember{ mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp,),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "First Screen",
            modifier = Modifier,
fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            // Specify other parameters as needed
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })
        ElevatedButton(onClick = {
            navigationToSecondScreen()
        }) {
            Text(text = "Next Screen")
        }

    }
}
@Composable
fun MyApp(){
    val navController =  rememberNavController()
    NavHost(navController = navController,
        startDestination = "firstScreen",
        ){
        composable("firstscreen"){
            FirstScreen {
                navController.navigate("secondscreen")
            }
        }
        composable(route= "secondscreen"){
            SecondScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
   FirstScreen({})
}

package com.maiscommenosapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.maiscommenosapp.ui.GreetingImage
import com.maiscommenosapp.ui.StartPage
import com.maiscommenosapp.ui.theme.MaisComMenosAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //val navController = rememberNavController()
            MaisComMenosAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    GreetingImage("")
                    StartPage()

}
            }
        }
    }
}


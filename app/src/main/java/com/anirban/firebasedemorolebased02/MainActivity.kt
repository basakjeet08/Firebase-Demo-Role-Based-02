package com.anirban.firebasedemorolebased02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.anirban.firebasedemorolebased02.core.theme.CustomAppTheme
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.navigation.AuthenticationNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomAppTheme {
                val navController = rememberNavController()
                AuthenticationNavGraph(navController = navController)
            }
        }
    }
}
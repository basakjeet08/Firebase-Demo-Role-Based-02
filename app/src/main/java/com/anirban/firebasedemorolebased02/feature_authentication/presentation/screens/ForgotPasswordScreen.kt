package com.anirban.firebasedemorolebased02.feature_authentication.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anirban.firebasedemorolebased02.R
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.components.TextButtonUI
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.navigation.AuthenticationRoutes

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Surface(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextButtonUI(textToShow = R.string.create_an_account) {

                // This Executes when we press the TextButton
                navController.navigate(AuthenticationRoutes.RegisterRoute.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
    }
}
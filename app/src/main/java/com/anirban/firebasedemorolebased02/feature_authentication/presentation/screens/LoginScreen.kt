package com.anirban.firebasedemorolebased02.feature_authentication.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.anirban.firebasedemorolebased02.R
import com.anirban.firebasedemorolebased02.core.theme.CustomAppTheme
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.components.TextButtonUI
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.navigation.AuthenticationRoutes


// This is the Preview function of the Login Screen
@Preview("Light")
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DefaultPreview() {
    CustomAppTheme {
        LoginScreen(navController = rememberNavController())
    }
}


@Composable
fun LoginScreen(
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


            TextButtonUI(textToShow = R.string.forgot_password) {

                // This Executes when we press the TextButton
                navController.navigate(AuthenticationRoutes.ForgotPasswordRoute.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }


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
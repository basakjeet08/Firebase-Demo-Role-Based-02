package com.anirban.firebasedemorolebased02.feature_authentication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.screens.ForgotPasswordScreen
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.screens.LoginScreen
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.screens.RegisterScreen

@Composable
fun AuthenticationNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthenticationRoutes.LoginRoute.route,
        builder = {
            composable(
                AuthenticationRoutes.LoginRoute.route,
                content = { LoginScreen(navController = navController) }
            )

            composable(
                AuthenticationRoutes.RegisterRoute.route,
                content = { RegisterScreen(navController = navController) }
            )

            composable(
                AuthenticationRoutes.ForgotPasswordRoute.route,
                content = { ForgotPasswordScreen(navController = navController) }
            )
        }
    )
}
package com.anirban.firebasedemorolebased02.feature_authentication.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.anirban.firebasedemorolebased02.R
import com.anirban.firebasedemorolebased02.core.theme.CustomAppTheme
import com.anirban.firebasedemorolebased02.core.theme.buttonShape
import com.anirban.firebasedemorolebased02.core.theme.custom_icons.Visibility
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.components.GradientButton
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.components.TextButtonUI
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.components.UserInputUI
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.navigation.AuthenticationRoutes
import com.anirban.firebasedemorolebased02.feature_authentication.presentation.stateholder.LoginViewModel


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

    // Focus Manager for Input Text Fields
    val focusManager = LocalFocusManager.current
    // ViewModel variable
    val myViewModel: LoginViewModel = viewModel()


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

            // User Input Email Field
            UserInputUI(
                userInput = myViewModel.userInputEmail,
                inputFieldLabel = R.string.email,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                trailingIcon = {
                    if (myViewModel.userInputEmail != "") {
                        IconButton(onClick = { myViewModel.clearUserInputEmail() }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                        }
                    }
                }
            ) {
                myViewModel.changeUserInputEmail(it)
            }

            // Spacing of 16dp
            Spacer(modifier = Modifier.height(16.dp))

            // User Input Password Field
            UserInputUI(
                userInput = myViewModel.userInputPassword,
                inputFieldLabel = R.string.password,
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = myViewModel.passwordShowState(),

                // It is the Eye Icon (show Password) to be Showed as a Trailing Icon
                trailingIcon = {
                    IconButton(onClick = { myViewModel.changePasswordHideStatus() }) {
                        val visibilityIcon =
                            if (myViewModel.showPassword) Visibility.VisibilityOn else Visibility.VisibilityOff
                        val description =
                            if (myViewModel.showPassword) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                }
            ) {
                myViewModel.changeUserInputPassword(it)
            }

            // Spacing of 16dp
            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            GradientButton(buttonShape = buttonShape, buttonText = R.string.login) {
                myViewModel.sendFirebaseLoginRequest()
            }

            // Spacing of 16dp
            Spacer(modifier = Modifier.height(16.dp))

            // Forgot Password Text Button
            TextButtonUI(textToShow = R.string.forgot_password) {

                // This Executes when we press the TextButton
                navController.navigate(AuthenticationRoutes.ForgotPasswordRoute.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }

            // Create an Account Text Button
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
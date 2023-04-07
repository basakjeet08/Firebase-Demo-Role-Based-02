package com.anirban.firebasedemorolebased02.feature_authentication.presentation.stateholder

import android.util.Log.d
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var userInputEmail: String by mutableStateOf("")
        private set

    var userInputPassword: String by mutableStateOf("")
        private set

    var showPassword: Boolean by mutableStateOf(false)
        private set

    fun changeUserInputEmail(newEmail: String) {
        userInputEmail = newEmail
    }

    fun changeUserInputPassword(newPassword: String) {
        userInputPassword = newPassword
    }

    fun clearUserInputEmail() {
        userInputEmail = ""
    }

    fun passwordShowState(): VisualTransformation {
        if (showPassword)
            return VisualTransformation.None
        return PasswordVisualTransformation()
    }


    fun changePasswordHideStatus() {
        showPassword = !showPassword
    }

    fun resetToDefault() {
        userInputEmail = ""
        userInputPassword = ""
        showPassword = false
    }

    fun sendFirebaseLoginRequest() {

        d("Login View Model", "Email : $userInputEmail \t Password : $userInputPassword")
    }

}
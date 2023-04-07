package com.anirban.firebasedemorolebased02.feature_authentication.presentation.stateholder

import android.util.Log.d
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel : ViewModel() {

    // Firebase Authentication Variable
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    var userInputEmail: String by mutableStateOf("")
        private set

    var userInputPassword: String by mutableStateOf("")
        private set

    var userInputRePassword: String by mutableStateOf("")
        private set

    // Variable which records whether to show the Password Entered by the User
    var showEnterPassword: Boolean by mutableStateOf(false)
        private set

    // Variable which records whether to show the Password Entered by the User
    var showReEnterPassword: Boolean by mutableStateOf(false)
        private set

    var checked: Boolean by mutableStateOf(false)
        private set


    fun updateChecked(newValue: Boolean) {
        checked = newValue
    }


    fun updateUserInputEmail(newEmail: String) {
        userInputEmail = newEmail
    }

    fun updateUserInputPassword(newPassword: String) {
        userInputPassword = newPassword
    }

    fun updateUserInputRePassword(newPassword: String) {
        userInputRePassword = newPassword
    }

    fun clearUserInputEmail() {
        userInputEmail = ""
    }

    // This function returns the VisualTransformation of the Enter Password
    fun enterPasswordShowState(): VisualTransformation {
        if (showEnterPassword)
            return VisualTransformation.None
        return PasswordVisualTransformation()
    }

    // This function returns the VisualTransformation of the Enter Password
    fun enterRePasswordShowState(): VisualTransformation {
        if (showReEnterPassword)
            return VisualTransformation.None
        return PasswordVisualTransformation()
    }

    fun changeEnterPasswordStatus() {
        showEnterPassword = !showEnterPassword
    }

    fun changeReEnterPasswordStatus() {
        showReEnterPassword = !showReEnterPassword
    }

    fun postSignInRequestFirebase() {

        d(
            "Register View Model",
            "Email : $userInputEmail \t Password : $userInputPassword \t Confirm Pass : $userInputRePassword \t Checked : $checked"
        )

//        firebaseAuth.signInWithEmailAndPassword(userInputEmail, userInputPassword)
//            .addOnSuccessListener {
//
//            }
//            .addOnFailureListener {
//
//            }
    }
}
package com.anirban.firebasedemorolebased02.feature_authentication.presentation.util

sealed class RegistrationState{

    object Initialized : RegistrationState()
    object Loading : RegistrationState()
    object Success : RegistrationState()
    class Failure(val errorMessage : String) : RegistrationState()
}

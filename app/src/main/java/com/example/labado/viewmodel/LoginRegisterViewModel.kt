package com.example.labado.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.labado.model.AuthAppRepository
import com.google.firebase.auth.FirebaseUser


class LoginRegisterViewModel(application: Application): AndroidViewModel(application) {
    private var authAppRepository: AuthAppRepository? = null
    private var userLiveData: MutableLiveData<FirebaseUser>? = null

    init {
        authAppRepository = AuthAppRepository(application)
        userLiveData = authAppRepository!!.getUserLiveData()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun login(email: String?, password: String?) {
        authAppRepository!!.login(email, password)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun register(email: String?, password: String?) {
        authAppRepository!!.register(email, password)
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser>? {
        return userLiveData
    }
}
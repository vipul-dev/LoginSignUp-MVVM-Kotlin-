package com.dev.pvaeps.ui.fragment.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.pvaeps.network.Resource
import com.dev.pvaeps.repository.AuthRepository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signUpResponse: MutableLiveData<Resource<SignUpResponse>> = MutableLiveData()
    val signUpResponse: LiveData<Resource<SignUpResponse>>
        get() = _signUpResponse


    fun signUp(
        firstName:String,
        lastName:String,
        phoneNo:String,
        email:String,
        password:String
    ){
        viewModelScope.launch {
            _signUpResponse.value=repository.signUp(firstName,lastName,phoneNo,email,password)
        }
    }

}
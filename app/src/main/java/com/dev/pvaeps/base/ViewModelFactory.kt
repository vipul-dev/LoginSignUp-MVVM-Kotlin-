package com.dev.pvaeps.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.pvaeps.repository.AuthRepository
import com.dev.pvaeps.ui.fragment.login.LoginViewModel
import com.dev.pvaeps.ui.fragment.signup.SignUpViewModel

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(SignUpViewModel::class.java)-> SignUpViewModel(repository as AuthRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}
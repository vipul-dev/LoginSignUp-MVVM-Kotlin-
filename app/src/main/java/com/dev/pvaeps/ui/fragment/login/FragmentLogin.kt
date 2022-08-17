package com.dev.pvaeps.ui.fragment.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.dev.pvaeps.databinding.FragmentLogInBinding
import com.dev.pvaeps.network.Resource
import com.dev.pvaeps.repository.AuthRepository
import com.dev.pvaeps.utils.AppPreferences
import com.dev.pvaeps.base.BaseFragment

class FragmentLogin : BaseFragment<LoginViewModel, FragmentLogInBinding, AuthRepository>() {


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLogInBinding.inflate(inflater, container, false)

    override fun getViewModel() = LoginViewModel::class.java

    override fun getFragmentRepository() =
        AuthRepository(requireContext())


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                    AppPreferences.userAccessToken = it.value.token

                    Handler(Looper.getMainLooper()).postDelayed({
                        Toast.makeText(
                            requireContext(),
                            AppPreferences.userAccessToken,
                            Toast.LENGTH_SHORT
                        ).show()
                    }, 3000)
                }

                is Resource.Failure -> {
                    Toast.makeText(requireContext(), it.errorBody.toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })

        /*binding.text.text.toString()*/

        //@todo add validations

        viewModel.login("ranjeet@apivenue.in", "123456")

        binding.tvSignUp.setOnClickListener {
            val action = FragmentLoginDirections.actionFragmentLoginToFragmentSignUp()
            findNavController().navigate(action)
        }
    }

}
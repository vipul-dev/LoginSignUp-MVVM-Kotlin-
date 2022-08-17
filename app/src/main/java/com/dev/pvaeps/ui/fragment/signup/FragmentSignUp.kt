package com.dev.pvaeps.ui.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.dev.pvaeps.base.BaseFragment
import com.dev.pvaeps.databinding.FragmentSignUpBinding
import com.dev.pvaeps.network.Resource
import com.dev.pvaeps.repository.AuthRepository

class FragmentSignUp : BaseFragment<SignUpViewModel, FragmentSignUpBinding, AuthRepository>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignUpBinding.inflate(inflater, container, false)

    override fun getViewModel() = SignUpViewModel::class.java

    override fun getFragmentRepository() = AuthRepository(requireContext())

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.signUpResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {

                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), it.errorBody.toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.clSignUp.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvSignUp.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val phoneNumber = binding.etMobile.text.toString()
            val email = binding.etEmailAddress.text.toString()
            val password = binding.etPassword.text.toString()

            //@todo add validations

//            viewModel.signUp("firstName", "lastName", "8751516870", "anushcaUID@payvenue.in", "password")
        }
    }

}
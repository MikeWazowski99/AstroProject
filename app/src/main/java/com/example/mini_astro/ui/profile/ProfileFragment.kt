package com.example.mini_astro.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mini_astro.MainActivity
import com.example.mini_astro.R
import com.example.mini_astro.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        auth = FirebaseAuth.getInstance()

        binding.signUpBtn.setOnClickListener {
            val email = binding.emailTextField.text.toString()
            val password = binding.passwordTextField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "Account registered successfully", Toast.LENGTH_SHORT).show()
                       // val intent = Intent(requireContext(), MainActivity::class.java)
                        //startActivity(intent)
                    }
                }.addOnFailureListener {
                    Toast.makeText(requireContext(), "Please enter a valid email address and password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter a valid email address and password", Toast.LENGTH_SHORT).show()
            }
        }


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}
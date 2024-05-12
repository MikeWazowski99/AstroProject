package com.example.mini_astro.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.android.volley.toolbox.JsonObjectRequest
import com.example.mini_astro.databinding.FragmentDashboardBinding
import com.example.mini_astro.ui.dashboard.api.RetrofitHelper
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val retrofit = RetrofitHelper.getInstance()
    private val KEY = "YMh7ZTkZLTgePotvWEd5JjPQexbtvAKVFQLhieQg"
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }
    private fun initUI() {
        initRetrofit()
    }

    private fun initRetrofit() {
        lifecycleScope.launch(Dispatchers.IO) {
            val myResponse = retrofit.getNasaData(KEY, date = "2024-05-07")

            if (myResponse.isSuccessful) {

                val response = myResponse.body()
                Log.i("Testing in fragment", myResponse.body().toString())
                if (response != null) {

                    withContext(Dispatchers.Main) {
                        Picasso.get().load(response.url).into(binding.ivUrl)
                        binding.tvTitle.text = response.title
                        binding.tvDate.text = response.date
                        binding.tvExplanation.text = response.expedition

                    }

                }

            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //var url = "https://api.nasa.gov/planetary/apod?api_key=YMh7ZTkZLTgePotvWEd5JjPQexbtvAKVFQLhieQg"
        val textView: TextView = binding.textDashboard
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
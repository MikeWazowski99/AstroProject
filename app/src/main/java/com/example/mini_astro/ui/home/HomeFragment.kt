package com.example.mini_astro.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mini_astro.R
import com.example.mini_astro.adapter.MyAdapter
import com.example.mini_astro.databinding.FragmentHomeBinding
import com.example.mini_astro.modals.MyModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up recycler view

        lateinit var recyclerView: RecyclerView
        lateinit var gridLayoutManager: GridLayoutManager
        lateinit var arrayList: ArrayList<MyModel>
        lateinit var thisAdapter: MyAdapter

        lateinit var staggered: StaggeredGridLayoutManager



        //gridLayoutManager = GridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false)
        staggered = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        _binding!!.rv1.layoutManager = staggered
        _binding!!.rv1.setHasFixedSize(true)

        // all about data

        arrayList = setupData()
        thisAdapter = MyAdapter(this, arrayList)
        _binding!!.rv1.adapter = thisAdapter

        val textView: TextView = binding.textHome
        return root
    }

    private fun setupData(): ArrayList<MyModel>{
        var items: ArrayList<MyModel> = ArrayList()
        items.add(MyModel(R.drawable.space1,"Hello World"))
        items.add(MyModel(R.drawable.space2,"Hello World this is the picture I took the other day"))
        items.add(MyModel(R.drawable.space3,"Hello This is a picture of the sky"))
        items.add(MyModel(R.drawable.space4,"Hello World again"))

        return items
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
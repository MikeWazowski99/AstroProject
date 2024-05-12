package com.example.mini_astro.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mini_astro.R
import com.example.mini_astro.adapter.MyAdapter2
import com.example.mini_astro.databinding.FragmentNotificationsBinding
import com.example.mini_astro.modals.myModel2
import com.example.mini_astro.R.layout.grid_item
import com.example.mini_astro.R.layout.grid_item2

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)


        lateinit var recyclerView: RecyclerView
        lateinit var gridLayoutManager: GridLayoutManager
        lateinit var arrayList2: ArrayList<myModel2>
        lateinit var thisAdapter: MyAdapter2
        val addButton = binding.root.getViewById(grid_item2)
        lateinit var staggered: StaggeredGridLayoutManager



        //gridLayoutManager = GridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false)
        staggered = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        _binding!!.rv2.layoutManager = staggered
        _binding!!.rv2.setHasFixedSize(true)

        // all about data

        arrayList2 = setupData2()
        thisAdapter = MyAdapter2(this, arrayList2)
        _binding!!.rv2.adapter = thisAdapter

        addButton.setOnClickListener {
            // Add a new item to the ArrayList
            arrayList2.add(myModel2(R.mipmap.like_icon, "You liked a post!"))
            thisAdapter.notifyDataSetChanged() // Notify the adapter of the data change
        }

        val root: View = binding.root
        return root
    }

    private fun setupData2(): ArrayList<myModel2> {
        val items: ArrayList<myModel2> = ArrayList()
        items.add(myModel2(R.mipmap.like_icon, "Placeholder"))
        return items
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
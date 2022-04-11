package com.luka.muzzplayer.ui.library

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.luka.muzzplayer.adapters.LibraryRecyclerAdapter
import com.luka.muzzplayer.base.BaseFragment
import com.luka.muzzplayer.databinding.FragmentLibraryBinding
import com.luka.muzzplayer.util.OnItemClickListener

class LibraryFragment :
    BaseFragment<FragmentLibraryBinding>(FragmentLibraryBinding::inflate) {

    private lateinit var libraryAdapter:LibraryRecyclerAdapter
    private val viewModel: LibraryFragmentViewModel by viewModels()

    override fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        viewModel.init()
        initRecycler()
        setObservers()
    }

    private fun initRecycler(){


        libraryAdapter = LibraryRecyclerAdapter(object: OnItemClickListener{
            override fun clickItem(position: Int, title:String) {
                Toast.makeText(requireContext(), title, Toast.LENGTH_SHORT).show()
            }

        })
        binding.rvLibrary.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvLibrary.adapter = libraryAdapter

    }

    private fun setObservers(){
        viewModel.musicCollection.observe(viewLifecycleOwner){musicList ->
            libraryAdapter.setData(musicList.toMutableList())
        }
    }
}
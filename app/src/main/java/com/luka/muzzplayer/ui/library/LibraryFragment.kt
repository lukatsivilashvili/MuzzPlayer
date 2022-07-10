package com.luka.muzzplayer.ui.library

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.luka.muzzplayer.adapters.LibraryRecyclerAdapter
import com.luka.muzzplayer.base.BaseFragment
import com.luka.muzzplayer.databinding.FragmentLibraryBinding
import com.luka.muzzplayer.ui.player.PlayerActivity
import com.luka.muzzplayer.util.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            override fun clickItem(uri: Uri, title:String) {
                launchPlayer(contentUri = uri)
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

    private fun launchPlayer(contentUri:Uri){
        val intent = Intent(requireContext(), PlayerActivity::class.java).also {
            it.putExtra("CONTENT_URI", contentUri)
            startActivity(it)
        }
    }
}
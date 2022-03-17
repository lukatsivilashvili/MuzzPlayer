package com.luka.muzzplayer.ui.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.luka.muzzplayer.models.MusicModel
import com.luka.muzzplayer.R
import com.luka.muzzplayer.adapters.LibraryRecyclerAdapter
import com.luka.muzzplayer.base.BaseFragment
import com.luka.muzzplayer.databinding.FragmentLibraryBinding

class LibraryFragment :
    BaseFragment<FragmentLibraryBinding>(FragmentLibraryBinding::inflate) {

    private lateinit var libraryAdapter:LibraryRecyclerAdapter

    override fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        initRecycler()
    }

    private fun initRecycler(){
        val musicList = mutableListOf<MusicModel>()
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))
        musicList.add(MusicModel(R.drawable.rectangle, "Redbone", "Childish gambino", "3:34"))


        libraryAdapter = LibraryRecyclerAdapter()
        binding.rvLibrary.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvLibrary.adapter = libraryAdapter
        libraryAdapter.setData(musicList)
    }
}
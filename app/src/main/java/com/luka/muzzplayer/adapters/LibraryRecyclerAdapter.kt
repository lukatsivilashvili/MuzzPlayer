package com.luka.muzzplayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luka.muzzplayer.models.MusicModel
import com.luka.muzzplayer.databinding.RvMusicItemBinding

class LibraryRecyclerAdapter : RecyclerView.Adapter<LibraryRecyclerAdapter.MusicItemViewHolder>() {

    val musicList = mutableListOf<MusicModel>()

    inner class MusicItemViewHolder(private val binding: RvMusicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var model: MusicModel

        fun bind() {
            model = musicList[adapterPosition]
            binding.tvMusicTitle.text = model.title
            binding.tvMusicArtist.text = model.artist
            binding.tvMusicItemLength.text = model.duration.toString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicItemViewHolder {
        val musicItemView =
            RvMusicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicItemViewHolder(musicItemView)
    }

    override fun onBindViewHolder(holder: MusicItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = musicList.size

    fun setData(music:MutableList<MusicModel>){
        musicList.addAll(music)
        notifyDataSetChanged()
    }

}
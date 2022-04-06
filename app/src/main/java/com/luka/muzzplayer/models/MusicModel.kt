package com.luka.muzzplayer.models

data class MusicModel(
    val id:String,
    val title: String,
    val album: String,
    val artist:String,
    val duration:Long = 0
)

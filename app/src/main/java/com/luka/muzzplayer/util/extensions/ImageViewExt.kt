package com.luka.muzzplayer.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.luka.muzzplayer.R

fun ImageView.loadFromUri(uri:String){
    Glide.with(this.context)
        .load(uri)
        .placeholder(R.drawable.ic_group_2)
        .into(this)
}
package com.luka.muzzplayer.util.extensions

import android.widget.TextView

fun TextView.loadDuration(dur:Long){
    val minutes = dur / 1000 / 60
    val seconds = dur / 1000 % 60

    this.text = if (seconds < 10) "$minutes:0$seconds" else "$minutes:$seconds"
}
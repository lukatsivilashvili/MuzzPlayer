package com.luka.muzzplayer.ui.library

import android.annotation.SuppressLint
import android.app.Application
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luka.muzzplayer.models.MusicModel
import java.io.File

@SuppressLint("StaticFieldLeak")
class LibraryFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>()

    private val _musicCollection = MutableLiveData<ArrayList<MusicModel>>()
    val musicCollection: LiveData<ArrayList<MusicModel>> = _musicCollection

    fun init() {
        loadMediaFiles()
    }


    private fun loadMediaFiles() {

        val tempList = ArrayList<MusicModel>()

        val selection = MediaStore.Audio.Media.IS_MUSIC + " !=0"
        val sortOrder = "${MediaStore.Audio.Media.TITLE} ASC"
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.ALBUM_ID
        )

        val query = context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            sortOrder,
            null
        )
        query?.use { cursor ->
            val titleColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val albumColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)
            val artistColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val durationColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
            val albumIdColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)

            while (cursor.moveToNext()) {
                val id = cursor.getString(idColumn)
                val title = cursor.getString(titleColumn)
                val album = cursor.getString(albumColumn)
                val artist = cursor.getString(artistColumn)
                val duration = cursor.getLong(durationColumn)
                val albumId = cursor.getLong(albumIdColumn).toString()
                val uri = Uri.parse("content://media/external/audio/albumart")
                val artUri = Uri.withAppendedPath(uri, albumId).toString()
                val musicItem = MusicModel(id, title, album, artist, duration, artUri)
                tempList.add(musicItem)
            }
        }
        _musicCollection.postValue(tempList)
    }
}
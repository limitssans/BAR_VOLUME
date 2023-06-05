package com.example.myfriend

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class MyFriends(
    @PrimaryKey(autoGenerate = true)
    val temanId: Int? = null,
    val nama: String,
    val kelamin: String,
    val email: String,
    val telp: String,
    val alamat: String
)

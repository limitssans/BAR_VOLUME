package com.example.myfriend

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import androidx.lifecycle.LiveData

@Dao
interface MyFriendDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahTeman(friends: MyFriends)

    @Query("SELECT * FROM MyFriends")
    fun ambilSemuaTeman(): LiveData<List<MyFriends>>
}
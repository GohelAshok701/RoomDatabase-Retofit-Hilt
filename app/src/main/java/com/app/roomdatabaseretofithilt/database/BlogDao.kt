package com.app.roomdatabaseretofithilt.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.roomdatabaseretofithilt.responses.Blog

@Dao
interface BlogDao {
    @Query("SELECT * FROM Blog")
    fun getAll(): List<Blog>

    @Insert
    fun insertAll(users: List<Blog>)

    @Query("DELETE FROM Blog")
    fun delete()
}
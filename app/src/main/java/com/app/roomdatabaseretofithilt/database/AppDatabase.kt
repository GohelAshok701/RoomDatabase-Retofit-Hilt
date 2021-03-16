package com.app.roomdatabaseretofithilt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.roomdatabaseretofithilt.responses.Blog

@Database(entities = arrayOf(Blog::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun blogDao(): BlogDao
}
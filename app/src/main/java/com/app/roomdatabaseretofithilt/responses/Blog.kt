package com.app.roomdatabaseretofithilt.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Blog(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id:Int,
    @ColumnInfo
    var pk: Int,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var body: String,
    @ColumnInfo
    var image: String,
    @ColumnInfo
    var category: String
) {

}
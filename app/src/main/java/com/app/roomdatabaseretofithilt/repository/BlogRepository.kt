package com.app.roomdatabaseretofithilt.repository

import com.app.roomdatabaseretofithilt.network.ApiService
import javax.inject.Inject

class BlogRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getBlogs() = apiService.getBlogs()
}
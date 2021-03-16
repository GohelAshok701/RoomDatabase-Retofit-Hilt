package com.app.roomdatabaseretofithilt.network

import com.app.roomdatabaseretofithilt.responses.Blog
import retrofit2.http.GET

interface ApiService {
    @GET("blogs")
    suspend fun getBlogs(): List<Blog>
}
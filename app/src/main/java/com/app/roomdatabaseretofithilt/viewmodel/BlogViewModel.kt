package com.app.roomdatabaseretofithilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.app.roomdatabaseretofithilt.database.BlogDao
import com.app.roomdatabaseretofithilt.repository.BlogRepository
import com.app.roomdatabaseretofithilt.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val blogRepository: BlogRepository,
    private val blogDao: BlogDao
) : ViewModel() {

    fun getBlog() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = blogRepository.getBlogs()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getBlogDao(): BlogDao {
        return blogDao;
    }
}
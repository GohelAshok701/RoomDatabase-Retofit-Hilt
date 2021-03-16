package com.app.roomdatabaseretofithilt

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.roomdatabaseretofithilt.adapter.BlogAdapter
import com.app.roomdatabaseretofithilt.database.AppDatabase
import com.app.roomdatabaseretofithilt.databinding.ActivityMainBinding
import com.app.roomdatabaseretofithilt.responses.Blog
import com.app.roomdatabaseretofithilt.utility.Status
import com.app.roomdatabaseretofithilt.viewmodel.BlogViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    private val blogViewModel: BlogViewModel by viewModels()
    lateinit var blogAdapter: BlogAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvBlogs.layoutManager = LinearLayoutManager(this)

        binding.btnCallApi.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCallApi -> {
                callBlogAPI()
            }
        }
    }

    fun callBlogAPI() {
        blogViewModel.getBlog().observe(this, Observer {
            it.let { resource ->
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.progress.visibility = View.GONE
                        resource.data?.let {
                            var blogList = it
                            blogViewModel.getBlogDao().delete()
                            blogViewModel.getBlogDao().insertAll(blogList)
                            blogAdapter = BlogAdapter()
                            binding.rvBlogs.adapter = blogAdapter
                            blogAdapter.updateBlogList(blogViewModel.getBlogDao().getAll())
                        }
                    }
                    Status.LOADING -> {
                        binding.progress.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        binding.progress.visibility = View.GONE
                    }
                }
            }
        })
    }

}
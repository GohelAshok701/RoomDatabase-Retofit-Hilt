package com.app.roomdatabaseretofithilt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.roomdatabaseretofithilt.R
import com.app.roomdatabaseretofithilt.responses.Blog

class BlogAdapter :
    RecyclerView.Adapter<BlogAdapter.BlogHolder>() {

    lateinit var blogList: List<Blog>

    class BlogHolder(v: View) : RecyclerView.ViewHolder(v) {
        var txtTitle: TextView = v.findViewById(R.id.txtTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.raw_blog, parent, false)
        return BlogHolder(itemView)
    }

    override fun getItemCount(): Int {
        return blogList.size
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
        holder.txtTitle.text = blogList.get(position).title
    }

    fun updateBlogList(blogList: List<Blog>) {
        this.blogList = blogList
        notifyDataSetChanged()
    }
}
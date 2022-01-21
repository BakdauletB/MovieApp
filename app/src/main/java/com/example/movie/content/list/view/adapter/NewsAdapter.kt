package com.example.movie.content.list.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.common.utils.setImage
import com.example.movie.content.list.model.response.PopularModel
import com.example.movie.content.list.view.NewsFragment

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {
    private var callback: NewsFragment

    private val newsListM: ArrayList<PopularModel> = ArrayList()

    constructor(callback: NewsFragment) : super(){
        this.callback = callback
    }
    fun addList(newList: List<PopularModel>){
        this.newsListM.clear()
        this.newsListM.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = newsListM.size

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bind(popularModel = newsListM[position],callback)
    }
    class NewsAdapterViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        private val tvTitle = root.findViewById<TextView>(R.id.name)
        private val tvReleaseDate = root.findViewById<TextView>(R.id.release_date)
        private val ivImg = root.findViewById<ImageView>(R.id.image)

        fun bind(popularModel: PopularModel, callback: NewsFragment){
            ivImg.setImage(popularModel.poster_path)
            tvTitle.text = popularModel.title
            tvReleaseDate.text = popularModel.release_date
            root.setOnClickListener {
                callback.navigate(popularModel.id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false)
        return NewsAdapterViewHolder(root)
    }
}

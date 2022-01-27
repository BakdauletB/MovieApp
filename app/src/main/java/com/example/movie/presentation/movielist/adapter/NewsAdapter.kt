package com.example.movie.presentation.movielist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.utils.setImage
import com.example.movie.data.model.Results

class NewsAdapter(private val callBack: (result: Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {

    private val newsListM: ArrayList<Results> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false)
        return NewsAdapterViewHolder(itemView,callBack)
    }
    override fun getItemCount(): Int  = newsListM.size
    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bind(results = newsListM[position])
    }
    fun addList(newList: List<Results>){
        this.newsListM.clear()
        this.newsListM.addAll(newList)
        notifyDataSetChanged()
    }
    class NewsAdapterViewHolder(private val root: View,
                                private val callBack: (result: Int) -> Unit)
        : RecyclerView.ViewHolder(root) {
        private val tvTitle = root.findViewById<TextView>(R.id.name)
        private val tvReleaseDate = root.findViewById<TextView>(R.id.release_date)
        private val ivImg = root.findViewById<ImageView>(R.id.image)

        fun bind(results: Results){
            ivImg.setImage(results.poster_path)
            tvTitle.text = results.title
            tvReleaseDate.text = results.release_date
            root.setOnClickListener {
                callBack.invoke(results.id)
            }
        }
    }
}

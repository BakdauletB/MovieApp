package com.example.movie.presentation.character.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.utils.setImage
import com.example.movie.data.model.MovieModel

class NewsAdapter(private val callBack: (result: Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {

    private val newsListM: ArrayList<MovieModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false)
        return NewsAdapterViewHolder(itemView,callBack)
    }

    override fun getItemCount(): Int  = newsListM.size


    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bind(movieModel = newsListM[position])

    }
    fun addList(newList: List<MovieModel>){
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

        fun bind(movieModel: MovieModel){
            ivImg.setImage(movieModel.poster_path)
            tvTitle.setText(movieModel.title)
            tvReleaseDate.text = movieModel.release_date
            root.setOnClickListener {
                callBack.invoke(movieModel.id)
            }

        }

    }


}

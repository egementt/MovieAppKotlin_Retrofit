package com.tokgozdev.moviekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tokgozdev.moviekotlin.R
import com.tokgozdev.moviekotlin.adapter.RecyclerViewAdapter.RowHolder
import com.tokgozdev.moviekotlin.model.Search
import com.tokgozdev.moviekotlin.view.MovieActivity
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(private val movieList: ArrayList<Search>, movieActivity: MovieActivity)
    : RecyclerView.Adapter<RowHolder>() {


    class RowHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bind(search: Search){

            Picasso.get().load(search.Poster).into(itemView.imageView)
            itemView.title_text.text = search.Title
            itemView.year_text.text = search.Year
            itemView.type_text.text = search.Type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
       return movieList.size
    }

}
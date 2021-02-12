package com.tokgozdev.moviekotlin.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tokgozdev.moviekotlin.R
import com.tokgozdev.moviekotlin.adapter.RecyclerViewAdapter
import com.tokgozdev.moviekotlin.model.Search
import kotlinx.android.synthetic.main.activity_movie.*
import java.io.Serializable

class MovieActivity : AppCompatActivity(){

    private lateinit var list: ArrayList<Search>
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

       val extras = intent.extras
        list = extras?.getParcelableArrayList<Search>("movies") as ArrayList<Search>

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        list.let {
            recyclerViewAdapter = RecyclerViewAdapter(it,this)
            recyclerView.adapter = recyclerViewAdapter
        }



    }


}
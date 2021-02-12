package com.tokgozdev.moviekotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tokgozdev.moviekotlin.R
import com.tokgozdev.moviekotlin.adapter.RecyclerViewAdapter
import com.tokgozdev.moviekotlin.model.Movie
import com.tokgozdev.moviekotlin.model.Search
import com.tokgozdev.moviekotlin.service.MovieAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val BaseUrl = "https://www.omdbapi.com/"
    private var movieList: ArrayList<Search>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {
            if(movieEditText != null){
                val movie = movieEditText.text.toString()
                loadData(movie)


            }else{
                Toast.makeText(baseContext, "Please enter movie or series",Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun loadData(movie: String){
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MovieAPI::class.java)
        val call = service.getData( movie,"api key here")

        call.enqueue(object : Callback<Movie> {

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    response.body()?.let {

                        movieList = ArrayList(it.Search)


                            movieList?.let {

                                intent = Intent(this@MainActivity, MovieActivity::class.java).apply {
                                    putParcelableArrayListExtra("movies", it as java.util.ArrayList<out Parcelable>)
                                }

                                startActivity(intent)


                            }
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                t.printStackTrace()
            }

        }

        )
    }


}







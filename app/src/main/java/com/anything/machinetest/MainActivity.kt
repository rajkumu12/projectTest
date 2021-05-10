package com.anything.machinetest

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var progerssProgressDialog: ProgressDialog
    lateinit var recyclerView: RecyclerView
    var dataList = ArrayList<Articles>()
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recy_newslist) as RecyclerView
        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        //crating an arraylist to store users using the data class user
        progerssProgressDialog=ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()
    }

    private fun getData() {
        val call: Call<News> = ApiClient.getClient.getTasks("wsj.com","b284fc22a0e54ac2af0d31face61b0bd")
        call.enqueue(object : Callback<News> {

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                progerssProgressDialog.dismiss()
                Log.d("mdhdhhdhdhhd", response!!.body()!!.totalResults.toString())
                val adapter = response!!.body()!!.articles?.let { RecyclerviewAdapter(it) }

                //now adding the adapter to recyclerview
               recyclerView .adapter = adapter
            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.d("mdhdhhdhdhhd", t?.localizedMessage.toString())
                progerssProgressDialog.dismiss()
            }

        })
    }
}
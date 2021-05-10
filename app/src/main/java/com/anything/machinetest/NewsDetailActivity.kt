package com.anything.machinetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        var heading:TextView= findViewById(R.id.tv_headline) as TextView
        var des:TextView= findViewById(R.id.tv_contents) as TextView
        var images:ImageView= findViewById(R.id.news_pic) as ImageView


       val headline:String= intent.getStringExtra("head").toString()
       val image:String= intent.getStringExtra("image").toString()
       val description:String= intent.getStringExtra("des").toString()


        heading.text=headline
        des.text=description
        Glide.with(this).load(image).centerCrop().into(images)


    }
}
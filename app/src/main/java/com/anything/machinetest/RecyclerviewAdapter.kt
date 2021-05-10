package com.anything.machinetest

import android.content.Intent
import android.nfc.tech.NfcA.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.newsview.view.*
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class RecyclerviewAdapter (val userList: ArrayList<Articles>) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.newsview, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(articles: Articles) {
            val textViewName = itemView.findViewById(R.id.headline) as TextView
            val textViewAddress  = itemView.findViewById(R.id.description) as TextView
            val imageview  = itemView.findViewById(R.id.action_image) as ImageView
           textViewName.text = articles.title
            textViewAddress.text = articles.description
            Glide.with(itemView.context).load(articles.urlToImage).centerCrop().into(imageview)

            itemView?.setOnClickListener {
                val intent = Intent(itemView.context,NewsDetailActivity::class.java);
                intent.putExtra("head", articles.title)
                intent.putExtra("des", articles.description)
                intent.putExtra("image", articles.urlToImage)
                itemView.context.startActivity(intent);
            }
        }
    }
}
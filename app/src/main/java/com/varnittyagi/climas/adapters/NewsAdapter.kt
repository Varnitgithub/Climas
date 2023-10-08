package com.varnittyagi.climas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.varnittyagi.climas.R
import com.varnittyagi.climas.model_classes.gnews_model.CurrentNewsModel
import com.varnittyagi.climas.model_classes.gnews_model.New

class NewsAdapter  (private var context: Context, private var listener:OnItemClickListener) : RecyclerView.Adapter<NewsAdapter.mviewHolder>() {
    private val items = ArrayList<New>()

    val API_BASE_URL = "https://tutorials.mianasad.com/ecommerce"
    val PRODUCT_IMAGE_URL = "/uploads/product/"
    class mviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val  newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        val  imageArrow: ImageView = itemView.findViewById(R.id.imagearrow)
        val description: TextView = itemView.findViewById(R.id.description)
        val title:TextView = itemView.findViewById(R.id.title)
        val date:TextView = itemView.findViewById(R.id.date)
    }




    fun updateList(newList: ArrayList<New>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mviewHolder {
        val view = mviewHolder(LayoutInflater.from(context).inflate(R.layout.allnews_item,parent,false))
view.imageArrow.setOnClickListener{
    listener.onItemClicks(items,view.adapterPosition)
}
        return view
    }

    override fun onBindViewHolder(holder: mviewHolder, position: Int) {
        val currentitem = items[position]
        Glide.with(context).load(currentitem.image)
            .into(holder.newsImage)
        holder.description.text = currentitem.description
        holder.title.text = currentitem.title
        holder.date.text = currentitem.published
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface OnItemClickListener {
        fun onItemClicks(modelClass:ArrayList<New>, position: Int)
    }
}



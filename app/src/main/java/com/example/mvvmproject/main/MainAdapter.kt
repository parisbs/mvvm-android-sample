package com.example.mvvmproject.main

import com.blindoapp.uitools.recyclerview.Adapter
import com.blindoapp.uitools.recyclerview.ViewHolder
import com.example.mvvmproject.R
import com.example.data.entities.ToDo
import kotlinx.android.synthetic.main.item_example.view.*

class MainAdapter : Adapter<ToDo> (){

    override fun bind(item: ToDo, viewHolder: ViewHolder) {
        viewHolder.itemView.text.text = "${item.title}: ${item.message}"
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_example

    fun addOneItem(item: ToDo) {
        items.add(item)
        notifyDataSetChanged()
    }
}

package com.utsman.androidmvvm

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utsman.androidmvvm.model.Data
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(private val list: MutableList<Data>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        return MyHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_view, p0, false))
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: MyHolder, p1: Int) {

        p0.itemView.name_text.text = list[p1].firstName + " " + list[p1].lastName
        p0.itemView.id_text.text = list[p1].id.toString()
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
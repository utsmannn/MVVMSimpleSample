package com.utsman.androidmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.utsman.androidmvvm.model.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listData: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidNetworking.initialize(this)

        myAdapter = MyAdapter(listData)
        val model = ViewModelProviders.of(this).get(MyViewModel::class.java)

        model.getData().observe(this, Observer<MutableList<Data>> {
            it?.let { list ->
                listData.addAll(list)
                myAdapter.notifyDataSetChanged()

                Log.i("ANJIR", it.size.toString())
            }
        })

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = myAdapter
    }
}

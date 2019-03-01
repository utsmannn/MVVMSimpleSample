package com.utsman.androidmvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.utsman.androidmvvm.model.Data
import com.utsman.androidmvvm.model.ReqresResponses

class MyViewModel : ViewModel() {
    private val baseUrl = "https://reqres.in/api/users?page=1"

    fun getData(): LiveData<MutableList<Data>> {
        val liveData: MutableLiveData<MutableList<Data>> = MutableLiveData()

        AndroidNetworking.get(baseUrl)
                .build()
                .getAsObject(ReqresResponses::class.java, object : ParsedRequestListener<ReqresResponses> {
                    override fun onResponse(response: ReqresResponses?) {
                        response?.let {
                            liveData.value = it.data
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Log.e("ANJIR", anError?.localizedMessage)
                    }
                })

        return liveData
    }


}
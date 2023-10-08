package com.varnittyagi.climas.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.varnittyagi.climas.api_interface.ApiInterface
import com.varnittyagi.climas.model_classes.gnews_model.CurrentNewsModel
import com.varnittyagi.climas.model_classes.gnews_model.LatestNewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class repository(private val apiInterface: ApiInterface) {


   private var _livedata = MutableLiveData<CurrentNewsModel>()

    val liveData :LiveData<CurrentNewsModel>
        get() = _livedata

    private var _livedataLatestNews = MutableLiveData<LatestNewsModel>()

    val liveDataLatestNews :LiveData<LatestNewsModel>
        get() = _livedataLatestNews

  fun searchNews(){
        apiInterface.getCurrentData("Flipkart","en","x2tW7amoC5UPrNp3fydxkY9AyUlKdI8sgXhlgQ6oCbHbaQR2").enqueue(object : Callback<CurrentNewsModel?> {
            override fun onResponse(
                call: Call<CurrentNewsModel?>,
                response: Response<CurrentNewsModel?>
            ) {
                _livedata.postValue(response.body())
            }

            override fun onFailure(call: Call<CurrentNewsModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

   fun latestNews(){
        apiInterface.latestNews("en","x2tW7amoC5UPrNp3fydxkY9AyUlKdI8sgXhlgQ6oCbHbaQR2").enqueue(object : Callback<LatestNewsModel?> {
            override fun onResponse(
                call: Call<LatestNewsModel?>,
                response: Response<LatestNewsModel?>
            ) {
                _livedataLatestNews.postValue(response.body())
            }

            override fun onFailure(call: Call<LatestNewsModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
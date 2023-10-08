package com.varnittyagi.climas.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.varnittyagi.climas.R
import com.varnittyagi.climas.adapters.NewsAdapter
import com.varnittyagi.climas.databinding.MainActivityBinding
import com.varnittyagi.climas.model_classes.gnews_model.New
import com.varnittyagi.climas.repository.repository
import com.varnittyagi.climas.retrofit_instance.RetrofitInstance
import com.varnittyagi.climas.viewmodel.ViewModelClass
import com.varnittyagi.climas.viewmodel.ViewmodelFactory

class NewsScreen : ComponentActivity(), NewsAdapter.OnItemClickListener {
    private lateinit var binding: MainActivityBinding
    private lateinit var viewModelClass: ViewModelClass
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        val apiInterface = RetrofitInstance.apiInterfaceInstance
        val repository = repository(apiInterface)
        newsAdapter = NewsAdapter(this, this)
        viewModelClass =
            ViewModelProvider(this, ViewmodelFactory(repository))[ViewModelClass::class.java]
        binding.newsRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.newsRecyclerview.adapter = newsAdapter
//        viewModelClass.newsLiveData.observe(this) {
//          //  newsAdapter.updateList(it.news as ArrayList<New>)
//            Log.d("TAGGGGGGGGGGGG", "news: ${it.status} ")
//        }

//        viewModelClass.latestNewsLiveData.observe(this) {
//            Log.d("TAGGGGGGGGGG", "latest News: ${it.status}")
//        }
    }

    override fun onItemClicks(modelClass: ArrayList<New>, position: Int) {
        TODO("Not yet implemented")
    }
}
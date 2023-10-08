package com.varnittyagi.climas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varnittyagi.climas.model_classes.gnews_model.CurrentNewsModel
import com.varnittyagi.climas.model_classes.gnews_model.LatestNewsModel
import com.varnittyagi.climas.repository.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelClass(private val repository: repository) :ViewModel(){

    var newsLiveData :LiveData<CurrentNewsModel> = repository.liveData
    var latestNewsLiveData :LiveData<LatestNewsModel> = repository.liveDataLatestNews

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchNews()
        }
        viewModelScope.launch(Dispatchers.IO) {
            repository.latestNews()
        }
    }
}
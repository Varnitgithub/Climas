package com.varnittyagi.climas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.varnittyagi.climas.repository.repository

class ViewmodelFactory(private val repository: repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelClass(repository) as T
    }
}
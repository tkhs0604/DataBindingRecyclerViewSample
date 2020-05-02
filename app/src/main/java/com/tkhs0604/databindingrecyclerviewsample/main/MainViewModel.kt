package com.tkhs0604.databindingrecyclerviewsample.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tkhs0604.databindingrecyclerviewsample.main.model.MainListContent

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    private val _items = MutableLiveData<List<MainListContent>>(emptyList())
    val items: LiveData<List<MainListContent>>
        get() = _items

    private val _snackbarMessage = MutableLiveData<String>()
    val snackbarMessage: LiveData<String>
        get() = _snackbarMessage

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    init {
        loadItems()
    }

    private fun loadItems() {
        _isRefreshing.value = true
        _items.value = repository.loadItems()
        _isRefreshing.value = false
    }

    fun onRefresh() {
        loadItems()
    }

    fun onClickItem(position: Int) {
        setSnackbarMessage("onClickItem position: $position")
    }

    fun onClickButton(number: Int) {
        setSnackbarMessage("onClickButton number: $number")
    }

    private fun setSnackbarMessage(message: String) {
        _snackbarMessage.value = message
    }

}
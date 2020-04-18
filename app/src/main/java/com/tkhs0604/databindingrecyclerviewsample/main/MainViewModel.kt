package com.tkhs0604.databindingrecyclerviewsample.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkhs0604.databindingrecyclerviewsample.main.model.MainCell
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    private val _items = MutableLiveData<List<MainCell>>(emptyList())
    val items: LiveData<List<MainCell>>
        get() = _items

    private val _snackbarMessage = MutableLiveData<String>()
    val snackbarMessage: LiveData<String>
        get() = _snackbarMessage

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    init {
        viewModelScope.launch {
            _items.value = loadItems()
        }
    }

    private fun loadItems(): List<MainCell> {
        return repository.loadItems()
    }

    fun onRefresh() {
        _isRefreshing.value = true
        _items.value = loadItems()
        _isRefreshing.value = false
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
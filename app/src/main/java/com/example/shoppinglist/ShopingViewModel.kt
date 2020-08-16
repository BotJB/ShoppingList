package com.example.shoppinglist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopingViewModel(
    private val res:ShopingRepository
):ViewModel() {
    fun upsert(item:Shopping_item)= CoroutineScope(Dispatchers.Main).launch {
        res.upsert(item)
    }
    fun delete(item:Shopping_item)= CoroutineScope(Dispatchers.Main).launch {
        res.delete(item)
    }
    fun getalllist()=res.getalllist()
}
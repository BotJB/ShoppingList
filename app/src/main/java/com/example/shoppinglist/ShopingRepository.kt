package com.example.shoppinglist

class ShopingRepository(
    private val db:Shoping_Database
) {
    suspend fun upsert(item:Shopping_item)=db.getDao().upsert(item)
    suspend fun delete(item:Shopping_item)=db.getDao().delete(item)
    fun getalllist()=db.getDao().getAllItems()
}
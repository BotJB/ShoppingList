package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Shopping_dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item:Shopping_item)
    @Delete
    suspend fun delete(item:Shopping_item)
    @Query("SELECT * FROM shoping_item")
     fun getAllItems():LiveData<List<Shopping_item>>
}
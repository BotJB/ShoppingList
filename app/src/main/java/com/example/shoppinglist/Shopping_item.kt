package com.example.shoppinglist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoping_item")
data class Shopping_item (
    @ColumnInfo(name="item")
     var itemname:String,
    @ColumnInfo(name = "quantity")
     var quantity:Int
){
    @PrimaryKey(autoGenerate = true)
     var id:Int?=null
}
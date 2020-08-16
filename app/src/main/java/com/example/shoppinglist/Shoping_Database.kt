package com.example.shoppinglist

import android.content.Context
import android.os.Build
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Shopping_item::class],
    version = 1
)
abstract class Shoping_Database :RoomDatabase(){
abstract fun getDao():Shopping_dao
    companion object{
        @Volatile
        private var instance:Shoping_Database?=null
        private var Lock=Any()
        operator fun invoke (context: Context)= instance?: synchronized(Lock){
            instance?: createDatabse(context).also { instance=it }
        }
        private fun createDatabse(context: Context)=Room.databaseBuilder(context.applicationContext,Shoping_Database::class.java,
            "shopingdb").build()

    }

}
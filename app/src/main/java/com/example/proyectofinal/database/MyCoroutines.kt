package com.example.proyectofinal.database

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class MyCoroutines (private var wishListDao: WishListDAO){

    suspend fun save(items: Item) = withContext(Dispatchers.IO){
        wishListDao.save(items.toEntity())
    }

    suspend fun delete(items: Item) = withContext(Dispatchers.IO){
        wishListDao.delete(items.toEntity())
    }

    suspend fun getItems(): LiveData<List<Item>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(wishListDao.getItemsFromDataBase().map { it.toItem() })

    }

    suspend fun getItem(itid: Item) = withContext(Dispatchers.IO){
        wishListDao.getItemById(itid.toString())
    }


}
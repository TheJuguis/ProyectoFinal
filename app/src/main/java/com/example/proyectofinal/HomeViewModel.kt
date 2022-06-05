package com.example.proyectofinal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.database.DatabaseManager
import kotlinx.coroutines.launch
import java.util.*
import com.example.proyectofinal.database.Item
import com.example.proyectofinal.database.MyCoroutines

class HomeViewModel : ViewModel(){
    fun saveItem(items: Item ){
        viewModelScope.launch{
            val wishListDAO = DatabaseManager.instance.database.wishListDAO()
            MyCoroutines(wishListDAO).save(items)
        }
    }

    fun deleteItem(items: Item ){
        viewModelScope.launch{
            val wishListDAO = DatabaseManager.instance.database.wishListDAO()
            MyCoroutines(wishListDAO).delete(items)
        }
    }

    val savedItems = MutableLiveData<List<Item>>()
    fun getItems(){
        viewModelScope.launch{
            val wishListDAO = DatabaseManager.instance.database.wishListDAO()
            savedItems.value = MyCoroutines(wishListDAO).getItems().value
        }
    }
    fun getItem(itid: Item){
        viewModelScope.launch {
            val wishListDAO = DatabaseManager.instance.database.wishListDAO()
            MyCoroutines(wishListDAO).getItem(itid)
        }
    }



}
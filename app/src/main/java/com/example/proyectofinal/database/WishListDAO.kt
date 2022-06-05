package com.example.proyectofinal.database

import androidx.room.*

@Dao
interface WishListDAO {

    @Query("SELECT * FROM $TABLE_WISHLIST")
    fun getItemsFromDataBase(): List<WishListEntity>

    @Query("SELECT * FROM $TABLE_WISHLIST WHERE product_id = :itid")
    fun getItemById(itid: String): WishListEntity

    @Delete
    fun delete(product: WishListEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(product: WishListEntity)


}
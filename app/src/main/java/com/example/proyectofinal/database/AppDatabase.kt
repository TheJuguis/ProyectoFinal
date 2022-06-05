package com.example.proyectofinal.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val TABLE_WISHLIST = "wishlist"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [WishListEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun wishListDAO(): WishListDAO
}
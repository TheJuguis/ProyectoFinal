package com.example.proyectofinal.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = TABLE_WISHLIST)
data class WishListEntity(
    @ColumnInfo(name = "product_id") @PrimaryKey(autoGenerate = true) val itid: Int = 0,
    @ColumnInfo(name = "product_name") val nombreProducto: String,
    @ColumnInfo(name = "product_price") val precio: String,
    @ColumnInfo(name = "product_descript") val descrip: String,
    @ColumnInfo(name = "product_calif") val calif: String,
)

fun WishListEntity.toItem() = Item(
    itid,
    nombreProducto,
    precio,
    descrip,
    calif

)
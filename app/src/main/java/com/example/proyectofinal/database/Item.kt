package com.example.proyectofinal.database

class Item(
    item_id: Int,
    item_name: String,
    item_price: String,
    item_descript: String,
    item_calif: String,
) {
    val itid: Int = item_id
    val itemname: String = item_name
    val itemprice: String = item_price
    val itemdescript: String = item_descript
    val itemcalif: String = item_calif
}

fun Item.toEntity() = WishListEntity(
    itid,
    itemname,
    itemprice,
    itemdescript,
    itemcalif
)
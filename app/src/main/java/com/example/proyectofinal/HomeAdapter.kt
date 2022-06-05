package com.example.proyectofinal

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.database.Item
import com.example.proyectofinal.databinding.ItemWishlistBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONObject


    private lateinit var database: DatabaseReference
class HomeAdapter(private val wishList: List<Item>): RecyclerView.Adapter<HomeAdapter.HomeHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val binding = ItemWishlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.render(wishList[position])

    }

    override fun getItemCount(): Int = wishList.size

    class HomeHolder(val binding: ItemWishlistBinding): RecyclerView.ViewHolder(binding.root){
        fun render(item: Item){

            binding.tvNombreProducto.setText(item.itemname)
            binding.tvPrecio.setText(item.itemprice)
            binding.tvDescrip.setText(item.itemdescript)
            binding.tvCalif.setText(item.itemcalif)
            binding.tvIdProducto.setText(item.itid.toString())




            val myDB = FirebaseDatabase.getInstance()
            database = myDB.reference












        }

    }

}
package com.example.proyectofinal

import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.proyectofinal.databinding.FragmentSearchBinding
import org.json.JSONObject

import androidx.fragment.app.viewModels
import com.example.proyectofinal.database.Item
import com.squareup.picasso.Picasso

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var queue: RequestQueue
    private val mainViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater)
        binding.contenedor.isVisible=false
        queue = Volley.newRequestQueue(context)
        binding.btnBuscar.setOnClickListener {

            Log.d("revisar", "Entra al boton")
            getItem()
            binding.contenedor.isVisible=true

        }








        //-----------------aniadir a wishlist----------------
        binding.btnAdd.setOnClickListener{

            val ides = binding.tvId.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvNombre.text.toString(),
                    item_price= binding.tvPrice.text.toString(),
                    item_descript = binding.tvDes.text.toString(),
                    item_calif = binding.tvCal.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }



        //-------------------------------------------------------



        return binding.root
    }

    fun getItem(){


        val url = "https://fakestoreapi.com/products/${binding.etBuscar.text.toString().lowercase()}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvNombre.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvId.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })
            binding.tvDes.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })

            binding.tvPrice.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvCal.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            val img = response.getString("image").replaceFirstChar { it.uppercase() }
            Picasso.get().load(img).into(binding.ivProductSearch)
            Log.d("imagenItem", "Link: $img")
        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue.add(jsonRequest)
    }
    override fun onStop() {
        super.onStop()
        queue.cancelAll("stopped")
    }

}
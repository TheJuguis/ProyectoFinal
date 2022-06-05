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
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectofinal.database.Item
import com.example.proyectofinal.databinding.ActivityMainBinding
import com.example.proyectofinal.databinding.FragmentHomeBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONObject


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var queue2: RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        queue2 = Volley.newRequestQueue(context)
        val navController = findNavController()

        val database = Firebase.database
        val myRef = database.reference


        homeViewModel.getItems()


        //RecyclerView de wishList

        homeViewModel.savedItems.observe(viewLifecycleOwner) {itemsList ->
            if(!itemsList.isNullOrEmpty()){
                for(item in itemsList){
                    Log.d("thesearetheitems", "Name: ${item.itemname} id ${item.itid} price:${item.itemprice}")

                    binding.rvWishList.adapter = HomeAdapter(itemsList)
                }
            }else{
                Log.d("thesearetheitems", "null or empty")
            }
        }
       /* binding.btnGuardar.setOnClickListener{


            homeViewModel.saveItem(
                Item(
                    0,
                    item_name = "Reloj",
                    item_price = "540",
                    item_descript = "Hermoso relij de munieca",
                    item_calif = "4.2"

                )
            )
            homeViewModel.getItems()


            homeViewModel.savedItems.observe(viewLifecycleOwner) {itemsList ->
                if(!itemsList.isNullOrEmpty()){
                    for(item in itemsList){
                        Log.d("thesearetheitems", "Name: ${item.itemname} id ${item.itid} price:${item.itemprice}")

                        binding.rvWishList.adapter = HomeAdapter(itemsList)
                    }
                }else{
                    Log.d("thesearetheitems", "null or empty")
                }
            }


        }*/

//----------------Consultar a la Firebase---------------------


        val myDB = FirebaseDatabase.getInstance()



        myRef.child("Perfiles").child("1").get().addOnSuccessListener { record ->


            val json = JSONObject(record.value.toString())
            Log.d("ValoresFirebase", "got value ${record.value}")
            binding.tvNick.setText(json.getString("Nickname").toString())
            binding.tvNombre.setText(json.getString("Nombre").toString())
            binding.tvNivel.setText("ERES NIVEL: ${json.getString("Nivel").toString()}")
            binding.tvPuntos.setText("Restan  ${json.getString("Puntos").toString()} puntos para el siguiente nivel")



        }





        //------------Eliminar de la WishList------------------------





        binding.btnEliminar.setOnClickListener {




                getDataItem()




        }





        //binding.buttonHomeToInside.setOnClickListener{

           // val testArgument = "desde el home"

           // val directions = HomeFragmentDirections.actionHomeFragmentToInsideHome(testArgument)
           // navController.navigate(directions)
        //}












        return binding.root









    }

    fun getDataItem(){


        val url = "https://fakestoreapi.com/products/${binding.etEliminar.text.toString().lowercase()}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response->
            binding.tvnombreElim.isVisible=false
            binding.tvnombreElim.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })


            binding.tvDescripElim.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })
            binding.tvDescripElim.isVisible=false
            binding.tvPrecioElim.isVisible=false
            binding.tvPrecioElim.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalifElim.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalifElim.isVisible=false

        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue2.add(jsonRequest)

        val idJ = binding.etEliminar.text.toString()
        val idJ2 = idJ.toInt()

        homeViewModel.deleteItem(

            Item(
               idJ2,
                binding.tvnombreElim.text.toString(),
                binding.tvPrecioElim.text.toString(),
                binding.tvDescripElim.text.toString(),
                binding.tvCalifElim.text.toString(),

            ))
        //Log.d("thesearetheitems", "ides2 : ${ides2}")


        homeViewModel.getItems()
    }
    override fun onStop() {
        super.onStop()
        queue2.cancelAll("stopped")
    }


}
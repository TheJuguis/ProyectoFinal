package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectofinal.database.Item

import com.example.proyectofinal.databinding.FragmentSugerenciasBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject

class SugerenciasFragment : Fragment() {

    private lateinit var binding: FragmentSugerenciasBinding
    private lateinit var queue: RequestQueue
    private val mainViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSugerenciasBinding.inflate(layoutInflater)

        queue = Volley.newRequestQueue(context)



        getItem()
        getItem2()
        getItem3()
        getItem4()
        getItem5()
        getItem6()




        binding.addWL1.setOnClickListener{

            val ides = binding.tvIdR1.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvtituloR1.text.toString(),
                    item_price= binding.tvPriceR1.text.toString(),
                    item_descript = binding.tvDesR1.text.toString(),
                    item_calif = binding.tvCalR1.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }

        binding.addWL2.setOnClickListener{

            val ides = binding.tvIdR2.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvtituloR2.text.toString(),
                    item_price= binding.tvPriceR2.text.toString(),
                    item_descript = binding.tvDesR2.text.toString(),
                    item_calif = binding.tvCalR2.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }

        binding.addWL3.setOnClickListener{

            val ides = binding.tvIdR3.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvtituloR3.text.toString(),
                    item_price= binding.tvPriceR3.text.toString(),
                    item_descript = binding.tvDesR3.text.toString(),
                    item_calif = binding.tvCalR3.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }

        binding.addWL4.setOnClickListener{

            val ides = binding.tvIdR4.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvtituloR4.text.toString(),
                    item_price= binding.tvPriceR4.text.toString(),
                    item_descript = binding.tvDesR4.text.toString(),
                    item_calif = binding.tvCalR4.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }

        binding.addWL5.setOnClickListener{

            val ides = binding.tvIdR5.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvtituloR5.text.toString(),
                    item_price= binding.tvPriceR5.text.toString(),
                    item_descript = binding.tvDesR5.text.toString(),
                    item_calif = binding.tvCalR5.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }

        binding.addWL6.setOnClickListener{

            val ides = binding.tvIdR6.text.toString()
            val ides2 = ides.toInt()
            mainViewModel.saveItem(
                Item(
                    item_id = ides2,
                    item_name = binding.tvtituloR6.text.toString(),
                    item_price= binding.tvPriceR6.text.toString(),
                    item_descript = binding.tvDesR6.text.toString(),
                    item_calif = binding.tvCalR6.text.toString()

                )
            )
            Toast.makeText(context, "Agregado a la WishList", Toast.LENGTH_LONG).show()
            mainViewModel.getItems()

        }

        return binding.root
    }



    fun getItem(){

        val rndm = (1..20).random()
        val url = "https://fakestoreapi.com/products/${rndm}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvtituloR1.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalR1.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvIdR1.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })

            binding.tvPriceR1.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvDesR1.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })

            Picasso.get().load(response.getString("image")).into(binding.imageView1)
        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue.add(jsonRequest)
    }
    fun getItem2(){

        val rndm = (1..20).random()
        val url = "https://fakestoreapi.com/products/${rndm}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvtituloR2.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalR2.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvIdR2.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })

            binding.tvPriceR2.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvDesR2.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })
            Picasso.get().load(response.getString("image")).into(binding.imageView2)

        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue.add(jsonRequest)
    }



    fun getItem3(){

        val rndm = (1..20).random()
        val url = "https://fakestoreapi.com/products/${rndm}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvtituloR3.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalR3.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvIdR3.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })

            binding.tvPriceR3.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvDesR3.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })

            Picasso.get().load(response.getString("image")).into(binding.imageView3)
        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue.add(jsonRequest)
    }

    fun getItem4(){

        val rndm = (1..20).random()
        val url = "https://fakestoreapi.com/products/${rndm}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvtituloR4.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalR4.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvIdR4.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })

            binding.tvPriceR4.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvDesR4.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })

            Picasso.get().load(response.getString("image")).into(binding.imageView4)
        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue.add(jsonRequest)
    }

    fun getItem5(){

        val rndm = (1..20).random()
        val url = "https://fakestoreapi.com/products/${rndm}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvtituloR5.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalR5.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvIdR5.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })

            binding.tvPriceR5.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvDesR5.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })
            Picasso.get().load(response.getString("image")).into(binding.imageView5)

        },
            Response.ErrorListener { errorMessage ->

                Log.d("JSONResponse", "error: $errorMessage")

            }
        )
        queue.add(jsonRequest)
    }

    fun getItem6(){

        val rndm = (1..20).random()
        val url = "https://fakestoreapi.com/products/${rndm}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{response->

            binding.tvtituloR6.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvCalR6.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvIdR6.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })

            binding.tvPriceR6.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvDesR6.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })
            Picasso.get().load(response.getString("image")).into(binding.imageView6)

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
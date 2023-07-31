package com.example.apimarte

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apimarte.Model.MarsRealstate
import com.example.apimarte.Model.RetrofitClient
import com.example.apimarte.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val listaInternet: MutableList<MarsRealstate> = mutableListOf()
    private val retrofitClient = RetrofitClient.getRetrofit()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Inicializador()
        obtenerDatos()
    }

    fun Inicializador() {
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = Adapter(listaInternet)
    }

    fun obtenerDatos() {
        retrofitClient.obtenerDatosApi().enqueue(object : retrofit2.Callback<List<MarsRealstate>> {
            override fun onResponse(call: Call<List<MarsRealstate>>, response: Response<List<MarsRealstate>>) {
                when (response.code()) {
                    in 200..299 -> {
                        listaInternet.clear() // Vaciar la lista actual
                        listaInternet.addAll(response.body() ?: emptyList()) // Agregar los nuevos datos
                        binding.recyclerview.adapter?.notifyDataSetChanged() // Notificar al adaptador
                    }
                    in 300..301 -> Log.d("Repo", "${response.code()} ----- ${response.errorBody()}")
                    else -> Log.d("Repo mayor a 300", "${response.code()} ---- ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<MarsRealstate>>, t: Throwable) {
                Log.e("error", "${t.message}")
            }
        })
    }
}

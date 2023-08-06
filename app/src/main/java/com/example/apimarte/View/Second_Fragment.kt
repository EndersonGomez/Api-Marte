package com.example.apimarte.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.apimarte.R
import com.example.apimarte.databinding.FragmentSecondBinding


class Second_Fragment : Fragment() {

    //Instanciamos el objeto de la clase viewBinding.
    private lateinit var binding: FragmentSecondBinding
    //Instanciamos las variables que recibiran los datos escogidos por el usuario.
    private var image: String? = null
    private var type: String? = null
    private var price: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Verificamos y asignamos los datos a las variables.
        arguments?.let { bundle ->

            image = bundle.getString("image")
            type = bundle.getString("type")
            price = bundle.getString("price")
            Log.d("Prueba","ID ${id} --- PRICE${price}--- TYPE ${type} --- IMAGE ${image}")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Seteamos los valores a la vista.
        binding.tvPrice.text = price
        binding.tvType.text = type
        Glide.with(binding.ivSeleccionado).load(image).placeholder(R.drawable.icon_downloading).error(R.drawable.icon_error).into(binding.ivSeleccionado)
    }
}
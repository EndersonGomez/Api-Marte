package com.example.apimarte

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apimarte.Model.MarsRealstate
import com.example.apimarte.databinding.MarsListItemBinding

class Adapter(private val lista: List<MarsRealstate>) :
    RecyclerView.Adapter<Adapter.MarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {

        return MarsViewHolder(MarsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {

        val item = lista[position]
        holder.render(item)
    }

    inner class MarsViewHolder(private val binding: MarsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val imagen = binding.ivImagen

        fun render(lista: MarsRealstate) {
            Log.d("Imagen URL", lista.image)
            Glide.with(imagen).load(lista.image).into(imagen)
            Log.d("Imagen", "Image loaded successfully")
        }

    }
}


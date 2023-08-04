package com.example.apimarte.View

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apimarte.Model.Local.MarsEntity
import com.example.apimarte.databinding.MarsListItemBinding
class Adapter() : RecyclerView.Adapter<Adapter.MarsViewHolder>() {

    private var listMars = listOf<MarsEntity>()

    fun update(list: List<MarsEntity>) {
        listMars = list
        notifyDataSetChanged()
        Log.d("Prueba Adapter", "Funcion update. Item count: ${list.size}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        Log.d("Prueba Adapter", "LLamada al oncreateView.")
        return MarsViewHolder(MarsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listMars.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val item = listMars[position]
        holder.render(item)
        Log.d("Prueba Adapter", "Item at position $position bound.")
    }

    inner class MarsViewHolder(private val binding: MarsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val imagen = binding.ivImagen
        private val price = binding.tvPrice

        fun render(lista: MarsEntity) {
            Log.d("Prueba Adapter", "Rendering item at position ${adapterPosition}: ${lista.image}")
            Glide.with(imagen).load(lista.image).into(imagen)
            price.text = lista.type
            Log.d("Prueba Adapter", "Image loaded successfully for item at position ${adapterPosition}")
        }
    }
}

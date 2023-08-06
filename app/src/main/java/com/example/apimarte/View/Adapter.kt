package com.example.apimarte.View


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apimarte.Model.Local.MarsEntity
import com.example.apimarte.R
import com.example.apimarte.databinding.MarsListItemBinding


class Adapter() : RecyclerView.Adapter<Adapter.MarsViewHolder>() {

    //Instanciamos una lista de la clase MarsEntity.
    private var listMars = listOf<MarsEntity>()

    //Variable que observa un dato mutable del tipo PhoneEntity.
    private val seleccionarTerreno = MutableLiveData<MarsEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<MarsEntity>) {
        listMars = list
        notifyDataSetChanged()
    }

    //Funcion para seleccionar el item escogido por el usuario.
    fun seleccionarTerrenoFuncion(): LiveData<MarsEntity> = seleccionarTerreno

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(MarsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listMars.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val item = listMars[position]
        holder.render(item)
    }

    inner class MarsViewHolder(binding: MarsListItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private val imagen = binding.ivImagen

        fun render(lista: MarsEntity) {

                Glide.with(imagen)
                    .load(lista.image)
                    .placeholder(R.drawable.icon_downloading)
                    .error(R.drawable.icon_error)
                    .into(imagen)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {

            seleccionarTerreno.value = listMars[adapterPosition]
        }
    }
}

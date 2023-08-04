package com.example.apimarte.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apimarte.ModelView.ViewModel
import com.example.apimarte.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {


    private lateinit var binding: FragmentFirstBinding
    private val viewmodel: ViewModel by activityViewModels()

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
    }

    fun Inicializador() {
        val adapter = Adapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        viewmodel.obtenerLista().observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.update(it)
                viewmodel.imprimirListaEnLog()
            }

        })
    }


}

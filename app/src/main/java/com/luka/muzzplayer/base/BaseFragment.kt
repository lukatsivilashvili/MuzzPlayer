package com.luka.muzzplayer.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflates<T> = (inflate: LayoutInflater, parent: ViewGroup?, attach: Boolean) -> T

abstract class BaseFragment<BN : ViewBinding>(private val inflate: Inflates<BN>) : Fragment() {
    private var _binding: BN? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null) {
            _binding = inflate.invoke(inflater, container, false)
        }
        initialize(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun initialize(inflater: LayoutInflater, container: ViewGroup?)
}
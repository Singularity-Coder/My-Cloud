package com.singularitycoder.mycloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.singularitycoder.mycloud.databinding.FragmentHostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = HostFragment()
    }

    private lateinit var binding: FragmentHostBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHostBinding.inflate(inflater, container, false)
        return binding.root
    }
}
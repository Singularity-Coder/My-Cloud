package com.singularitycoder.mycloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
    }

    private fun FragmentHostBinding.setupUI() {
        layoutCloudProfile.apply {
            ivCloudItemImage.setImageDrawable(requireContext().drawable(R.drawable.ic_outline_person_outline_24))
            tvTitle.text = "My Cloud Profile"
            tvCount.isVisible = false
        }
        layoutCloudGuests.apply {
            ivCloudItemImage.setImageDrawable(requireContext().drawable(R.drawable.ic_outline_group_work_24))
            tvTitle.text = "My Cloud Guests"
            tvCount.text = "331"
        }
        layoutDeviceInfo.apply {
            ivCloudItemImage.setImageDrawable(requireContext().drawable(R.drawable.ic_outline_info_24))
            tvTitle.text = "My Device Info"
            tvCount.isVisible = false
        }
    }
}
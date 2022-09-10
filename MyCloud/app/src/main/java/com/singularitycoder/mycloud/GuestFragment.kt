package com.singularitycoder.mycloud

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.singularitycoder.mycloud.databinding.FragmentGuestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuestFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = GuestFragment()
    }

    private lateinit var binding: FragmentGuestBinding

    private val hostsAdapter = HostsAdapter()
    private var duplicateHostList = mutableListOf<Host>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGuestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
        binding.setupUserActionListeners()
    }

    private fun FragmentGuestBinding.setupUI() {
        rvFlukes.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = hostsAdapter
        }
    }

    private fun FragmentGuestBinding.setupUserActionListeners() {
        etSearch.doAfterTextChanged { keyWord: Editable? ->
            ibClearSearch.isVisible = keyWord.isNullOrBlank().not()
            if (keyWord.isNullOrBlank()) {
                hostsAdapter.hostList = duplicateHostList
            } else {
                hostsAdapter.hostList = hostsAdapter.hostList.filter { it: Host -> it.name.contains(keyWord) }.toMutableList()
            }
            hostsAdapter.notifyDataSetChanged()
        }
        setDummyData()
        ibClearSearch.setOnClickListener {
            etSearch.setText("")
        }
    }

    private fun setDummyData() {
        val hostList = listOf<Host>(
            Host(
                name = "Jack the Black",
                rating = 3f,
                storageSpace = 32.0,
                ratingCount = 33
            ),
            Host(
                name = "Jenny",
                rating = 5f,
                storageSpace = 1002.0,
                ratingCount = 3203
            ),
            Host(
                name = "Rose",
                rating = 5f,
                storageSpace = 1020.0,
                ratingCount = 4002
            ),
            Host(
                name = "Lisa",
                rating = 5f,
                storageSpace = 908.0,
                ratingCount = 5993
            ),
            Host(
                name = "Jisoo",
                rating = 5f,
                storageSpace = 1100.0,
                ratingCount = 6729
            ),
            Host(
                name = "Monkey on the Hill",
                rating = 1.5f,
                storageSpace = 732.0,
                ratingCount = 8
            )
        )
        hostsAdapter.hostList = hostList.toMutableList()
        hostsAdapter.notifyDataSetChanged()
    }
}
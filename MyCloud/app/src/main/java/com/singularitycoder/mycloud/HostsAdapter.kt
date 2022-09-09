package com.singularitycoder.mycloud

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.singularitycoder.mycloud.databinding.ListItemHostBinding

class HostsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var hostList = mutableListOf<Host>()
    private var itemClickListener: (host: Host) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ListItemHostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ContactViewHolder).setData(hostList[position])
    }

    override fun getItemCount(): Int = hostList.size

    override fun getItemViewType(position: Int): Int = position

    fun setItemClickListener(listener: (host: Host) -> Unit) {
        itemClickListener = listener
    }

    inner class ContactViewHolder(
        private val itemBinding: ListItemHostBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(host: Host) {
            itemBinding.apply {
                tvHostName.text = host.name
                tvContactPhoneNumber.text = host.mobileNumber
                tvDateAdded.text = host.dateStarted.toIntuitiveDateTime()
                root.setOnClickListener {
                    itemClickListener.invoke(host)
                }
            }
        }
    }
}

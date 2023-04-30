package com.example.thed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thed.databinding.ItemBinding


class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    val stringList = mutableListOf<String>()
    class ViewHolder(view: View, val textView: TextView) :RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(viewGroup.context))
        return ViewHolder(itemBinding.root, itemBinding.textView)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = stringList[position]
    }
}

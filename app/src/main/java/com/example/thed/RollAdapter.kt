package com.example.thed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thed.databinding.RollBinding


class RollAdapter() : RecyclerView.Adapter<RollAdapter.ViewHolder>() {
    val rollList = mutableListOf<List<Int>>()
    class ViewHolder(view: View, val total: TextView, val dices: RecyclerView) :RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RollBinding.inflate(LayoutInflater.from(viewGroup.context))
        itemBinding.dices.layoutManager = LinearLayoutManager(viewGroup.context, LinearLayoutManager.HORIZONTAL, false)
        return ViewHolder(itemBinding.root, itemBinding.total, itemBinding.dices)
    }

    override fun getItemCount(): Int {
        return rollList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sum = rollList[position].sum()
        holder.total.text = "total: $sum"
        holder.dices.adapter = DiceAdapter(rollList[position])
    }
}

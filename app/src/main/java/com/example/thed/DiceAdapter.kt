package com.example.thed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thed.databinding.DiceBinding

class DiceAdapter(val diceList: List<Int>) : RecyclerView.Adapter<DiceAdapter.ViewHolder>() {
    class ViewHolder(view: View, val point: TextView) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val diceBinding = DiceBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(diceBinding.root, diceBinding.point)
    }

    override fun getItemCount(): Int {
        return diceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.point.text = "${diceList[position]}"
    }
}

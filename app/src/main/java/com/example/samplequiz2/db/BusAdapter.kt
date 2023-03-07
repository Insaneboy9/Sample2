package com.example.samplequiz2.db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplequiz2.databinding.ItemBusBinding

class BusAdapter(
    var items: List<Bus>,
) : RecyclerView.Adapter<BusAdapter.BusViewHolder>() {

    class BusViewHolder(binding: ItemBusBinding) : RecyclerView.ViewHolder(binding.root) {
        val textViewNum = binding.textViewBusNumber
        val textViewRoute = binding.textViewBusRoute
        val textViewCompany = binding.textViewBusCompany
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusViewHolder {
        return BusViewHolder(
            ItemBusBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BusViewHolder, position: Int) {
        val item = items[position]
        holder.textViewNum.text = item.num
        holder.textViewRoute.text = item.route
        holder.textViewCompany.text = item.company

    }

    override fun getItemCount(): Int {
        return items.size
    }

}
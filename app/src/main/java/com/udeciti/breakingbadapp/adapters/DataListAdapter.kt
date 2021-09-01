package com.udeciti.breakingbadapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udeciti.breakingbadapp.databinding.DataListItemBinding
import com.udeciti.breakingbadapp.models.Data

class DataListAdapter(private val data: List<Data>) : RecyclerView.Adapter<DataListAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: DataListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data){
            binding.image.setImageResource(data.image)
            binding.value.text = data.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.count()
    }
}
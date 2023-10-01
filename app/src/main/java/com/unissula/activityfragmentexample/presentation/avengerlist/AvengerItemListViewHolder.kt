package com.unissula.activityfragmentexample.presentation.avengerlist

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.unissula.activityfragmentexample.databinding.ItemListAvengersBinding
import com.unissula.activityfragmentexample.modul.Person

class AvengerItemListViewHolder(
    private val binding: ItemListAvengersBinding,
    private val onItemClick: (Person) -> Unit // membuat callback, function di dalam function
    // posisi Unit adalah returning function, tapi Unit artinya tidak mengembalikan nilai
) : RecyclerView.ViewHolder(binding.root) { // ViewHolder butuh view, sehingga deklarasikan binding itemnya lalu panggil disini

    // buat method bind yang berfungsi untuk menempelkan data yang nantinya akan dipanggil di onBindViewHolder di adapter
    fun bind(item: Person){ // posisi Person merupakan data yang akan dirender nantinya
        // setOnClick:
        binding.root.setOnClickListener{
            onItemClick.invoke(item)
        }

        // Menempelkan ke ViewHolder:
        binding.ivProfileImg.load(item.profilePictUrl)
        binding.tvName.text = item.name
    }
}
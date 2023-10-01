package com.unissula.activityfragmentexample.presentation.avengerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.unissula.activityfragmentexample.databinding.ItemListAvengersBinding
import com.unissula.activityfragmentexample.modul.Person

class AvengerListAdapter(private val onItemClick: (Person) -> Unit): // tambahkan callback yg akan digunakan pada onCreateViewHolder
    RecyclerView.Adapter<AvengerItemListViewHolder>() {
    // adapter akan mengextend class RecyclerView.Adapter<>
    // isi dari <> adalah ViewHoldernya

    // Tambahkan "differ" untuk men-filter data yang masuk, dan mencegah main thread yang terkunci
    private val differ = AsyncListDiffer(this,object : DiffUtil.ItemCallback<Person>(){
        // areItemsTheSame: meng-compare berdasarkan id, id nya berbeda atau tidak
        // id hanya contoh, areItemsTheSame akan mengcompare yang dituliskan di dalamnya
        // efektifnya areItemsTheSame harus mengcompare semua yang ada di dalam data class
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        // areItemsTheSame: meng-compare berdasarkan hascode, hashcode nya berbeda atau tidak
        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    fun setData(data: List<Person>) {
        differ.submitList(data)
        notifyItemRangeChanged(0,data.size)
        // bagian notifyItemRangeChanged harus diperhatikan lebih karena ini berguna untuk merefresh semua data yang ada di list nya
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengerItemListViewHolder {
        // untuk membuat ViewHolder (meng-instantiate viewholder yang sudah dibuat)
        return AvengerItemListViewHolder(
            binding = ItemListAvengersBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            ),
            onItemClick = onItemClick
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: AvengerItemListViewHolder, position: Int) {
        // untuk meletakkan data-data
        holder.bind(differ.currentList[position])
    }
}
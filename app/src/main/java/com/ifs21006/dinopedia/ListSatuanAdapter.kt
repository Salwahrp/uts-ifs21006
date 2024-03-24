package com.ifs21006.dinopedia
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21006.dinopedia.databinding.ItemRowDinoBinding

class ListSatuanAdapter(private val listDino: ArrayList<Satuan>) : RecyclerView.Adapter<ListSatuanAdapter.ListViewHolder>() {

        private lateinit var onItemClickCallback: ListSatuanAdapter.OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: ListSatuanAdapter.OnItemClickCallback
        ) {
            this.onItemClickCallback = onItemClickCallback
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSatuanAdapter.ListViewHolder {
            val binding = ItemRowDinoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
            return ListViewHolder(binding)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ListSatuanAdapter.ListViewHolder, position: Int) {
            val dino = listDino[position]
            holder.binding.ivItemDino.setImageResource(dino.photo)
            holder.binding.tNamaDino.text = dino.name
            holder.binding.tDescDino.text = dino.deskripsi
            holder.itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(listDino[holder.adapterPosition])
            }
        }

        override fun getItemCount(): Int = listDino.size

        class ListViewHolder(var binding: ItemRowDinoBinding) :
            RecyclerView.ViewHolder(binding.root)

        interface OnItemClickCallback {
            fun onItemClicked(data: Satuan)
        }
    }
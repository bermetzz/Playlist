package com.example.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.playlist.databinding.ItemSongsBinding

class SongAdapter(
    val songList: ArrayList<Song>,
    val onClick: (position: Int) -> Unit
    ): Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSongsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = songList.size

    inner class ViewHolder(private val binding: ItemSongsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = songList[adapterPosition]
            binding.apply {
                positionTv.text = item.pos.toString()
                nameTv.text = item.name
                artistTv.text = item.artist
                timeTv.text = item.time
            }
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
        }
    }
}
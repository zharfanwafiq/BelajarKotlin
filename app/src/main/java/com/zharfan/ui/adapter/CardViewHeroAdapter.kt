package com.zharfan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zharfan.belajarkotlin.databinding.ItemCardviewHeroBinding
import com.zharfan.data.Hero

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCardviewHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class ViewHolder(private val binding: ItemCardviewHeroBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(hero: Hero){
                binding.apply {
                    Glide.with(itemView.context)
                        .load(hero.photo)
                        .into(imgItemPhoto)

                    tvItemName.text =hero.name
                    tvItemDetail.text =hero.detail

                    btnSetFavorite.setOnClickListener{
                        Toast.makeText(itemView.context, "Favorite ${hero.name}",Toast.LENGTH_SHORT).show()
                    }
                    btnSetShare.setOnClickListener{
                        Toast.makeText(itemView.context, "Share ${hero.name}",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
}
package com.zharfan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zharfan.belajarkotlin.databinding.ItemGridHeroBinding
import com.zharfan.data.Hero

class GridHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroAdapter.ViewHolder {
        val view = ItemGridHeroBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.ViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size





    inner class ViewHolder(private val binding: ItemGridHeroBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(hero: Hero){
                    binding.apply {
                        Glide.with(itemView.context)
                            .load(hero.photo)
                            .apply(RequestOptions().override(350,550))
                            .into(imgItemPhoto)

                        tvHeroName.text =hero.name
                    }
                }
            }
}
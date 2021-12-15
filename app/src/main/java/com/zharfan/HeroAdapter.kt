package com.zharfan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zharfan.belajarkotlin.databinding.ActivityRecycleViewBinding
import com.zharfan.belajarkotlin.databinding.ItemHeroBinding

class HeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {


    fun setDataHero(hero: ArrayList<Hero>){
        listHero.clear()
        listHero.addAll(hero)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: HeroAdapter.ViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.ViewHolder {
        val  view = ItemHeroBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    inner class  ViewHolder(private val binding: ItemHeroBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(hero: Hero){
                    binding.apply {
                        Glide.with(itemView.context)
                            .load(hero.photo)
                            .apply(RequestOptions().override(55,55))
                            .into(imgItemPhoto)

                        tvHeroName.text = hero.name
                        tvHeroDesc.text = hero.detail
                    }
                }
            }

}
package com.zharfan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zharfan.belajarkotlin.databinding.ItemListHeroBinding
import com.zharfan.data.Hero
import com.zharfan.ui.helper.OnItemClickCallback

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view = ItemListHeroBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = listHero[position]
        holder.bind(pos)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(pos)
        }
    }

    override fun getItemCount(): Int = listHero.size

    inner class  ViewHolder(private val binding: ItemListHeroBinding) :
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
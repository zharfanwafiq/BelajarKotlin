package com.zharfan.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zharfan.belajarkotlin.R
import com.zharfan.belajarkotlin.databinding.ActivityRecycleViewBinding
import com.zharfan.data.Hero
import com.zharfan.data.HeroesData
import com.zharfan.ui.adapter.GridHeroAdapter
import com.zharfan.ui.adapter.ListHeroAdapter

class RecycleViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var listHeroAdapter: ListHeroAdapter
    private lateinit var gridHeroAdapter: GridHeroAdapter
    private var listHero : ArrayList<Hero> = arrayListOf()
    private var title : String = "Mode Grid"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setActionBArTitle(title)
        showData()
    }

    private fun showData() {
        listHero.addAll(HeroesData.listData)
        showRecyclerList()
        showRecyclerGrid()
    }

    private fun showRecyclerList() {
        listHeroAdapter = ListHeroAdapter(listHero)
            binding.apply {
                with(rvHero){
                    layoutManager = LinearLayoutManager(this@RecycleViewActivity)
                    rvHero.adapter = listHeroAdapter
                }
            }
    }
    private fun showRecyclerGrid() {
        gridHeroAdapter =GridHeroAdapter(listHero)
        binding.apply {
            with(rvHero){
                layoutManager = GridLayoutManager(this@RecycleViewActivity,2)
                rvHero.adapter = gridHeroAdapter
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)


    }

    private fun setActionBArTitle(title:String){
        supportActionBar?.title = title
    }

    private fun setMode(selectedMde: Int){
        when(selectedMde){
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()

            }
            R.id.action_grid -> {

                title ="Mode Grid"
                showRecyclerGrid()

            }
            R.id.action_cardview -> {

            }
        }
        setActionBArTitle(title)
    }
}
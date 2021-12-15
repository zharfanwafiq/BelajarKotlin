package com.zharfan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.zharfan.belajarkotlin.R
import com.zharfan.belajarkotlin.databinding.ActivityRecycleViewBinding

class RecycleViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleViewBinding
    private lateinit var heroAdapter: HeroAdapter
    private var listHero : ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setDataHero()
    }
    private fun setDataHero() {
        listHero.addAll(HeroesData.listData)
        heroAdapter = HeroAdapter(listHero)
        binding.apply {
            with(rvHero){
                layoutManager = LinearLayoutManager(this@RecycleViewActivity)
                rvHero.adapter =heroAdapter
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

    private fun setMode(selectedMde: Int){
        when(selectedMde){
            R.id.action_list -> {

            }
            R.id.action_grid -> {

            }
            R.id.action_cardview -> {

            }
        }
    }
}
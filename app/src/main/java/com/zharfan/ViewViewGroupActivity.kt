package com.zharfan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zharfan.belajarkotlin.R
import com.zharfan.belajarkotlin.databinding.ActivityViewViewGroupBinding


class ViewViewGroupActivity : AppCompatActivity() {

   private lateinit var binding: ActivityViewViewGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewViewGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Google Pixel"

        setOnClickButton()
    }

    private fun setOnClickButton() {
        binding.apply {
            btnBuy.setOnClickListener{
                Toast.makeText(this@ViewViewGroupActivity, "Silakan DI Beli", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
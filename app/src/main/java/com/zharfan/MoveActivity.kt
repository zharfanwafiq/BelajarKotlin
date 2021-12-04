package com.zharfan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zharfan.belajarkotlin.databinding.ActivityMoveBinding

class MoveActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMoveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
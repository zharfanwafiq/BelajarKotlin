package com.zharfan.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.zharfan.belajarkotlin.databinding.ActivityMainBinding
import com.zharfan.belajarkotlin.databinding.ActivityMoveBinding

class MoveActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMoveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
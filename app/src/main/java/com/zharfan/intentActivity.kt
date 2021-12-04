package com.zharfan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zharfan.belajarkotlin.R
import com.zharfan.belajarkotlin.databinding.ActivityIntentBinding

class intentActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickButton()
    }

    private fun onClickButton(){
        binding.apply {
            btnMoveToActivity.setOnClickListener(this@intentActivity)
        }
    }
    override fun onClick(view: View?) {
        when (view?.id){
            R.id.btnMoveToActivity -> {
                startActivity(Intent(this, MoveActivity::class.java))
            }
        }
    }
}
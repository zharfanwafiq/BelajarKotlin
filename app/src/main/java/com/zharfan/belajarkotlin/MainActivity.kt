package com.zharfan.belajarkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zharfan.belajarkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e(TAG,"onCreate: ")

        result()
        if (savedInstanceState != null){
            binding.apply {
                val volume =savedInstanceState.getString(TAG)
                tvResult.text = volume
            }
        }
    }

    private fun result(){
        binding.apply {
            btnResult.setOnClickListener{
                var isEmptyField = false

                val length = etLength.text.toString().trim()
                val width = etWidth.text.toString().trim()
                val height = etHeight.text.toString().trim()

                if (length.isEmpty()){
                    isEmptyField = true
                    etLength.error = "Field Ini Tidak boleh Kosong!!"
                }
                if (width.isEmpty()){
                    isEmptyField = true
                    etWidth.error = "Field Ini Tidak boleh Kosong!!"
                }
                if (height.isEmpty()){
                    isEmptyField = true
                    etHeight.error = "Field Ini Tidak boleh Kosong!!"
                }

                if (!isEmptyField) {
                    val volume = length.toDouble() * width.toDouble() * height.toDouble()
                    tvResult.text = volume.toString()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause: ")

    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG,"onRestart: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.apply {
            outState.putString(TAG, tvResult.text.toString())
        }
        Log.e(TAG, "onSaveInstanceState: ")
    }

}
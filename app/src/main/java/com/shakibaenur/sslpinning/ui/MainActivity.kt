package com.shakibaenur.sslpinning.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shakibaenur.sslpinning.R
import androidx.lifecycle.ViewModelProviders
import com.shakibaenur.sslpinning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.btnSearch.setOnClickListener {
            if (binding.etProfileName.text.isNotBlank()) {
                viewModel.getUserData(binding.etProfileName.text.toString())
                Log.d("TAG_TAG", "click")
            }
        }
    }
}
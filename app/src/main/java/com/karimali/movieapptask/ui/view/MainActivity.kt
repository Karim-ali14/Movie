package com.karimali.movieapptask.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.karimali.movieapptask.R
import com.karimali.movieapptask.commin.binder.viewBinding
import com.karimali.movieapptask.databinding.ActivityMainBinding
import com.karimali.movieapptask.ui.adapter.MoveAdapter
import com.karimali.movieapptask.ui.viewmodel.MoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val moveViewModel : MoveViewModel by viewModels()

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var moveAdapter: MoveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initAdapter()

        bindData()
    }

    private fun initAdapter() {
        moveAdapter = MoveAdapter(
            arrayListOf()
        )
    }

    private fun bindData() {
        binding.lifecycleOwner = this
        binding.moveViewModel = moveViewModel
        binding.moveAdapter = moveAdapter
    }
}
package com.karimali.movieapptask.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.karimali.movieapptask.commin.binder.viewBinding
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.databinding.ActivityMoveBinding
import com.karimali.movieapptask.ui.adapter.MoveAdapter
import com.karimali.movieapptask.ui.viewmodel.MoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoveActivity : AppCompatActivity() {

    private val moveViewModel : MoveViewModel by viewModels()

    private val binding by viewBinding(ActivityMoveBinding::inflate)

    private lateinit var moveAdapter: MoveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initAdapter()

        bindData()
    }

    private fun initAdapter() {
        moveAdapter = MoveAdapter(
            arrayListOf(),
            object : MoveAdapter.EventClicks {
                override fun onItemClick(model: MoveModel) {
                    startActivity(DetailsActivity.getInstance(
                        this@MoveActivity,
                        model.id ?: 0
                    ))
                }
            }
        )
    }

    private fun bindData() {
        binding.lifecycleOwner = this
        binding.moveViewModel = moveViewModel
        binding.moveAdapter = moveAdapter
    }
}
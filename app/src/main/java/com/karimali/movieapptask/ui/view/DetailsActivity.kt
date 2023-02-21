package com.karimali.movieapptask.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karimali.movieapptask.commin.binder.viewBinding
import com.karimali.movieapptask.databinding.ActivityDetailsBinding
import com.karimali.movieapptask.databinding.ActivityMoveBinding

class DetailsActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityDetailsBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
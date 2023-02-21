package com.karimali.movieapptask.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karimali.movieapptask.commin.binder.viewBinding
import com.karimali.movieapptask.commin.extension.showBackButton
import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.databinding.ActivityDetailsBinding
import com.karimali.movieapptask.databinding.ActivityMoveBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityDetailsBinding::inflate)

    companion object {
        fun getInstance(context:Context,moveId:Int) = Intent(context,DetailsActivity::class.java).apply {
            putExtra(Constants.Keys.MOVE_ID_KEY,moveId)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpViews()
    }

    private fun setUpViews() {
        showBackButton()
    }
}
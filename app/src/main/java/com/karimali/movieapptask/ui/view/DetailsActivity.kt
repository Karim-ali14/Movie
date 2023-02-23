package com.karimali.movieapptask.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.karimali.movieapptask.R
import com.karimali.movieapptask.commin.binder.viewBinding
import com.karimali.movieapptask.commin.extension.showBackButton
import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.databinding.ActivityDetailsBinding
import com.karimali.movieapptask.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityDetailsBinding::inflate)

    private val detailsViewModel:DetailsViewModel by viewModels()

    private  var moveId: Int? = null

    companion object {
        fun getInstance(context:Context,moveId:Int) = Intent(context,DetailsActivity::class.java).apply {
            putExtra(Constants.Keys.MOVE_ID_KEY,moveId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getArgs()
        setUpToolBar()
        setupObservable()
        setupObserver()
    }

    private fun getArgs() {
        intent.extras?.apply {
            moveId = getInt(Constants.Keys.MOVE_ID_KEY,0)
        }
        intent.data?.apply {
            moveId = getQueryParameter(Constants.Keys.MOVE_ID_KEY)?.toInt()
        }
    }

    private fun setupObservable() {
        detailsViewModel.fetchMoveDetails(moveId!!)
    }

    private fun setupObserver() {
        lifecycleScope.launch{
            detailsViewModel.moveDetails.collect{
                binding.moveItem = it.data
            }
        }
    }

    private fun setUpToolBar() {
        showBackButton()
        supportActionBar?.title = getString(R.string.details)
    }
}
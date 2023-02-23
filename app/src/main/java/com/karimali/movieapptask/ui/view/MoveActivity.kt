package com.karimali.movieapptask.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.karimali.movieapptask.commin.binder.viewBinding
import com.karimali.movieapptask.commin.utils.Constants
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.databinding.ActivityMoveBinding
import com.karimali.movieapptask.fcm.MyFirebaseMessagingService
import com.karimali.movieapptask.ui.adapter.MoveAdapter
import com.karimali.movieapptask.ui.viewmodel.MoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoveActivity : AppCompatActivity() {

    private val moveViewModel : MoveViewModel by viewModels()

    private val binding by viewBinding(ActivityMoveBinding::inflate)

    private lateinit var moveAdapter: MoveAdapter


    companion object {
        fun getInstance(context: Context) = Intent(context,MoveActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initAdapter()
        bindData()

        lifecycleScope.launch {
            moveViewModel.isLoading.collect{
                Log.i("ListenToIsLoading",it.toString())
            }
        }

        lifecycleScope.launch {
            moveViewModel.hasError.collect{
                Log.i("ListenToIsHasError",it.toString())
            }
        }

        lifecycleScope.launch {
            moveViewModel.hasData.collect{
                Log.i("ListenToIsHasData",it.toString())
            }
        }
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
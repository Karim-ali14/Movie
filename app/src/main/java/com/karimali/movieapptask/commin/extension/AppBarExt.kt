package com.karimali.movieapptask.commin.extension

import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showBackButton() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}
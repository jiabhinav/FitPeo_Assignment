package com.app.fitpeo.utils

import android.content.Context

import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.widget.ImageView
import com.app.fitpeo.R

import com.squareup.picasso.Picasso

fun ImageView.loadImage(imageUrl: String) {


        Picasso.get()
        .load(imageUrl)
        .placeholder(R.drawable.logo)
        .error(R.drawable.logo)
        .into(this)
            }

    fun Context.getBitmap(name:String): Bitmap
    {
        val file = this.getFileStreamPath(name)
        val imagePath: String = file.getAbsolutePath()
        val bitmapImage = BitmapFactory.decodeFile(imagePath)
        val nh = (bitmapImage.height * (100.0 / bitmapImage.width)).toInt()
        val bit = Bitmap.createScaledBitmap(bitmapImage, 100, nh, true)
        return bit
    }



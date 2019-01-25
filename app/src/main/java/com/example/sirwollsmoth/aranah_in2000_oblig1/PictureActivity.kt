package com.example.sirwollsmoth.aranah_in2000_oblig1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.widget.Button
import android.content.Intent
import android.view.View

class PictureActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val imageView = findViewById(R.id.test_image) as ImageView

        Glide
                .with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ole-Johan_Dahls_hus_20110911-11.JPG")
                .into(imageView)



        val nextButton = findViewById(R.id.next_button) as Button
        nextButton.setOnClickListener {
                val changePage = Intent(this, Converter::class.java)
                startActivity(changePage)
        }
    }





}

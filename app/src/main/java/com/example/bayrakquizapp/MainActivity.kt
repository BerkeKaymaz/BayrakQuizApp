package com.example.bayrakquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bayrakquizapp.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbCopy()

        binding.buttonBasla.setOnClickListener {
            startActivity(Intent(this@MainActivity,QuizActivity::class.java))
        }



    }

    fun dbCopy(){
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}
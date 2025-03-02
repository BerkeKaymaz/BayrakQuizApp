package com.example.bayrakquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bayrakquizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dogruSayac = intent.getIntExtra("dogruSayac",0)

        binding.textViewResult.text = "$dogruSayac DOĞRU ${5-dogruSayac} YANLIŞ"

        binding.textViewYuzdeSonuc.text = "%${(dogruSayac*100)/5} BAŞARI"


        binding.buttonTekrar.setOnClickListener {
            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }

    }
}
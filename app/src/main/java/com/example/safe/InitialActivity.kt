package com.example.safe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.safe.databinding.ActivityInitialBinding

class InitialActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityInitialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var intent = Intent(this,LoginActivity::class.java)

        binding.btnUserInitial.setOnClickListener(View.OnClickListener {
            startActivity(intent)
        })

        binding.btnAttendantInitial.setOnClickListener(View.OnClickListener {
            startActivity(intent)
        })
    }
}
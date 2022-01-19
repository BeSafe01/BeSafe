package com.example.safe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.safe.attendant.LoginActivityAttendant
import com.example.safe.attendant.RegisterActivityAttendant
import com.example.safe.databinding.ActivityInitialBinding
import com.example.safe.user.LoginActivityUser

class InitialActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityInitialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intentUser = Intent(this, LoginActivityUser::class.java)
        val intentAttendant = Intent(this, RegisterActivityAttendant::class.java)

        binding.btnUserInitial.setOnClickListener(View.OnClickListener {
            startActivity(intentUser)

        })

        binding.btnAttendantInitial.setOnClickListener(View.OnClickListener {
            startActivity(intentAttendant)
        })
    }
}
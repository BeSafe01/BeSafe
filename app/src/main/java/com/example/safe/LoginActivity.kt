package com.example.safe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.safe.databinding.ActivityInitialBinding
import com.example.safe.databinding.ActivityLoginBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        val db =  Firebase.firestore
        var cpf =  binding.edtCpfLogin;
        var password = binding.edtPasswordLogin;
        val txtCreate = binding.txtCreateNewAccount;

        binding.btnVerifyLoin.setOnClickListener(View.OnClickListener {
            if (cpf.text.isEmpty() || password.text.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }else{}
        })

        txtCreate.setOnClickListener( View.OnClickListener {

        })
    }
}
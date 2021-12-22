package com.example.safe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.safe.databinding.ActivityInitialBinding
import com.example.safe.databinding.ActivityLoginBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

  //  private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db =  Firebase.firestore
        var edtCpf =  binding.edtCpfLogin;
        var edtPassword = binding.edtPasswordLogin;
        val txtCreate = binding.txtCreateNewAccount;
        val btnVerifyLogin = binding.btnVerifyLoin

        btnVerifyLogin.setOnClickListener(View.OnClickListener {
            if (edtCpf.text.isEmpty() || edtPassword.text.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }else{
                val cpfRef = db.collection("users").document(edtCpf.text.toString())
                cpfRef.get().addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        val document = task.result
                        if (document != null){
                            var userCpf = document.id
                            if (userCpf.equals(edtCpf.text.toString())){
                                var passwordLogin =document.getString("password")
                                if (passwordLogin.equals(edtPassword.text.toString())){
                                    Toast.makeText(this,"Entrando", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this,MainActivity::class.java)
                                    startActivity(intent)
                                }else{
                                    Toast.makeText(this,"Senha incorreta", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }else{
                        Toast.makeText(this, "Usuario não encontrado (primeiro else)",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this,"Usuario não encontrado (Segundo else)", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        txtCreate.setOnClickListener( View.OnClickListener {
           val intent = Intent(this,RegisterActivityUser::class.java)
            startActivity(intent)
        })
    }
}
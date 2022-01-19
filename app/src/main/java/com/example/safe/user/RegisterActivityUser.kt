package com.example.safe.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.safe.databinding.ActivityRegisterUserBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivityUser : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegisterUser.setOnClickListener {
            //Mudar && para ||, preencha os
            if (binding.edtFullNameUser.text.isEmpty() || binding.edtCpfUser.text.isEmpty() ||
                binding.edtDateBirthUser.text.isEmpty() || binding.edtPhoneUser.text.isEmpty() ||
                binding.edtPhoneEmergencyUser.text.isEmpty() || binding.edtEmailUser.text.isEmpty() ||
                binding.edtPasswordUser.text.isEmpty() || binding.edtConfirmPasswordUser.text.isEmpty()){

                Toast.makeText(this,"Preencha os campos vazio", Toast.LENGTH_SHORT).show()

            }else{
                val user = UserModel(binding.edtFullNameUser.text.toString(), binding.edtEmailUser.text.toString(),
                    binding.edtPasswordUser.text.toString(),binding.edtCpfUser.text.toString() , binding.edtPhoneUser.text.toString() ,
                    binding.edtPhoneEmergencyUser.text.toString()  ,binding.edtDateBirthUser.text.toString() )

                db.collection("users")//Name Collection
                    .document(binding.edtCpfUser.text.toString())//Reference id: Cpf
                    .set(user)//put data in the database

                    .addOnSuccessListener {
                        Toast.makeText(this,"Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                        val intent = Intent (this, LoginActivityUser::class.java)
                        startActivity(intent)
                    }

                    .addOnFailureListener(OnFailureListener {
                        Toast.makeText(this,"Revise seus dados, Usuario não cadastrado", Toast.LENGTH_SHORT).show()
                    })
            }

        }
    }
}
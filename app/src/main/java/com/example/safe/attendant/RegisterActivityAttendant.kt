package com.example.safe.attendant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.safe.user.LoginActivityUser
import com.example.safe.user.UserModel
import com.example.safe.databinding.ActivityRegisterAttendantBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivityAttendant : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAttendantBinding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterAttendantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegisterAttendent.setOnClickListener {
            //Mudar && para ||, preencha os
            if (binding.edtFullNameAttendant.text.isEmpty() || binding.edtEmailAttendant.text.isEmpty() ||
                binding.edtPasswordAttendant.text.isEmpty() || binding.edtPasswordAttendant.text.isEmpty() ||
                binding.edtCpfAttendant.text.isEmpty() || binding.edtPhoneAttendant.text.isEmpty() ||
                binding.edtIdentificationCodeAttendant.text.isEmpty() || binding.edtDateBirthAttendant.text.isEmpty()){

                Toast.makeText(this,"Preencha os campos vazio", Toast.LENGTH_SHORT).show()

            }else{
                val user = UserModel(binding.edtFullNameAttendant.text.toString(), binding.edtEmailAttendant.text.toString(),
                    binding.edtPasswordAttendant.text.toString(), binding.edtCpfAttendant.text.toString() ,
                    binding.edtPhoneAttendant.text.toString()  ,binding.edtIdentificationCodeAttendant.text.toString(),binding.edtDateBirthAttendant.text.toString() )

                db.collection("attendant")//Name Collection
                    .document(binding.edtCpfAttendant.text.toString())//Reference id: Cpf
                    .set(user)//put data in the database

                    .addOnSuccessListener {
                        Toast.makeText(this,"Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                        val intent = Intent (this, LoginActivityAttendant::class.java)
                        startActivity(intent)
                    }

                    .addOnFailureListener(OnFailureListener {
                        Toast.makeText(this,"Revise seus dados, Usuario não cadastrado", Toast.LENGTH_SHORT).show()
                    })
            }

        }
    }
}
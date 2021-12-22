package com.example.safe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        setContentView(R.layout.activity_register_user)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)

        var btnRegisterUser = binding.btnRegisterUser
        var edtNameUser = binding.edtFullNameUser
        var edtCpfUser = binding.edtCpfUser
        var edtDateBirthUser = binding.edtDateBirthUser
        var edtPhoneUser = binding.edtPhoneUser
        var edtPhoneEmergencyUser = binding.edtPhoneEmergencyUser
        var edtEmailUser = binding.edtEmailUser
        var edtPasswordUser = binding.edtPasswordUser
        var edtConfirmPasswordUser = binding.edtConfirmPasswordUser

        btnRegisterUser.setOnClickListener(View.OnClickListener {
            if (edtNameUser.text.toString().isEmpty() && edtCpfUser.text.toString().isEmpty() &&
                    edtDateBirthUser.text.toString().isEmpty() && edtPhoneUser.text.toString().isEmpty() &&
                    edtPhoneEmergencyUser.text.toString().isEmpty() && edtEmailUser.text.toString().isEmpty() &&
                    edtPasswordUser.text.toString().isEmpty() && edtConfirmPasswordUser.text.toString().isEmpty()){

                Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
            val user = UserClass(edtNameUser.text.toString(), edtCpfUser.text.toString(),
                    edtDateBirthUser.text.toString(), edtPhoneUser.text.toString(),
                    edtPhoneEmergencyUser.text.toString(), edtEmailUser.text.toString(),
                    edtPasswordUser.text.toString())

            db.collection("users")//Name Collection
                .document(edtCpfUser.text.toString())//Reference id: Cpf
                .set(user)//put data in the database

                .addOnSuccessListener {
                    Toast.makeText(this,"Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                    val intent = Intent (this, LoginActivity::class.java)
                    startActivity(intent)
                }

                .addOnFailureListener(OnFailureListener {
                    Toast.makeText(this,"Revise seus dados, Usuario não cadastrado", Toast.LENGTH_SHORT).show()
                })
        })
    }
}
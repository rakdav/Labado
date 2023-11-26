package com.example.labado

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.labado.databinding.ActivityRegistationBinding
import com.example.labado.viewmodel.LoginRegisterViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.database


class RegistationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistationBinding
    private  lateinit var auth:FirebaseAuth
    private var loginRegisterViewModel: LoginRegisterViewModel? = null
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth=Firebase.auth
        val db = Firebase.database
        loginRegisterViewModel = ViewModelProvider(this)[LoginRegisterViewModel::class.java]
        binding = ActivityRegistationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regBackToMain.setOnClickListener {
            finish()
            Log.d("debug", "asdo")
        }

        binding.btnCreateAccount.setOnClickListener {
//            val f_name = binding.tiFName.text.toString()
//            val s_name = binding.tiSName.text.toString()
            val email = binding.tiEmail.text.toString()
            val pwd = binding.tiPassword.text.toString()
            val r_pwd = binding.tiRepPassword.text.toString()

//            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                Toast.makeText(applicationContext, "Почта введена неверно", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                // authentication
//            }
            if (email.isNotEmpty() && pwd.isNotEmpty() && pwd == r_pwd) {
                loginRegisterViewModel!!.register(email, pwd);
                var i=0
            } else {
                Toast.makeText(applicationContext, "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show()
            }

        }




    }
}
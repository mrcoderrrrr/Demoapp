package com.example.demoapps.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.demoapps.R
import com.example.demoapps.databinding.ActivityLoginBinding

class login_activity : AppCompatActivity() {
    lateinit var dataBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val SharedPreferences =getSharedPreferences("SignUpData", Context.MODE_PRIVATE)
        val editor = SharedPreferences.edit()
        //OnClick
        setClick(SharedPreferences,editor)
    }

    private fun setClick(SharedPreferences: SharedPreferences, editor: SharedPreferences.Editor) {
        dataBinding.butLogin.setOnClickListener {
            if (validate(SharedPreferences,editor)){
            }
        }
        dataBinding.tvSignupTxt.setOnClickListener{
                setSignUp()
        }
    }

    private fun validate(SharedPreferences: SharedPreferences, editor: SharedPreferences.Editor): Boolean {
        if (dataBinding.teEmail.text.toString().isEmpty()) {
            dataBinding.teEmail.setError("Username is mandatory")
        } else if (dataBinding.tePassword.text.toString().isEmpty()) {
            dataBinding.tePassword.setError("Password is manadatory")
        }
        else if (dataBinding.teEmail.text.toString().isEmpty() || dataBinding.tePassword.text.toString().isEmpty() ){
            dataBinding.teEmail.setError("Username is mandatory")
            dataBinding.tePassword.setError("Password is manadatory")
        }
        else {
            if (dataBinding.teEmail.text.toString().equals(SharedPreferences.getString("Email"," ")) && dataBinding.tePassword.text.toString().equals(SharedPreferences.getString("Password",""))) {
                setHome()
            } else {
                Toast.makeText(this, "Log in Faild", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }

    private fun setHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        Toast.makeText(this, "Log in Sucessfull", Toast.LENGTH_LONG).show()
    }

    private fun setSignUp() {
        dataBinding.tvSignupTxt.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
    }
    }


}
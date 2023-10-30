package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saving()
        clearing()
    }

    private fun saving() {
        var email:EditText=findViewById<AppCompatEditText>(R.id.editTextEmailAddress)
        var username:EditText=findViewById<AppCompatEditText>(R.id.editTextUsername)
        var firstName:EditText=findViewById<AppCompatEditText>(R.id.editTextFirstName)
        var lastName:EditText=findViewById<AppCompatEditText>(R.id.editTextLastName)
        var age:EditText=findViewById<AppCompatEditText>(R.id.editTextAge)
        var error:TextView=findViewById<AppCompatEditText>(R.id.textViewErrorMessage)
        findViewById<AppCompatButton>(R.id.button_save).setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                if(username.text.length<10 || !isValueInt(age.text.toString())  || email.text.toString() == "Email" ||
                    username.text.toString() == "Username" || firstName.text.toString() == "First Name"||
                    lastName.text.toString() == "Last Name" || email.text.toString() == "" ||
                    firstName.text.toString() == ""|| lastName.text.toString() == "" ||
                    !email.text.toString().contains("@") || !email.text.toString().contains(".")){
                    error.visibility = View.VISIBLE
                }
            }
        })
    }
    private fun isValueInt(value:String): Boolean{
        val res = value.toIntOrNull()
        return res != null && res>0
    }

    private fun clearing() {findViewById<AppCompatButton>(R.id.button_clear).setOnLongClickListener(object: View.OnLongClickListener{
    var email:EditText=findViewById<AppCompatEditText>(R.id.editTextEmailAddress)
    var username:EditText=findViewById<AppCompatEditText>(R.id.editTextUsername)
    var firstName:EditText=findViewById<AppCompatEditText>(R.id.editTextFirstName)
    var lastName:EditText=findViewById<AppCompatEditText>(R.id.editTextLastName)
    var age:EditText=findViewById<AppCompatEditText>(R.id.editTextAge)
    private val longPressDuration = 100
        private val handler = Handler()
        override fun onLongClick(v: View?): Boolean {
            handler.postDelayed({
                email.text.clear()
                username.text.clear()
                firstName.text.clear()
                lastName.text.clear()
                age.text.clear()
            }, longPressDuration.toLong())
            return true
        }
        })
    }
}

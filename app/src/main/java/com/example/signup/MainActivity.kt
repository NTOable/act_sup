package com.example.signup

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.text.InputType
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            // code to show password
                // store user input
            val onClick_cb_show = findViewById<CheckBox>(R.id.cb_show)
            val user_pw = findViewById<EditText>(R.id.pw)
            val user_cf_pw = findViewById<EditText>(R.id.cf_pw)
                // listener
                onClick_cb_show.setOnClickListener {
                    user_pw.inputType = InputType.TYPE_CLASS_TEXT
                    user_cf_pw.inputType = InputType.TYPE_CLASS_TEXT
        }
    }
}
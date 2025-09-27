package com.example.signup

import android.os.Bundle
import android.widget.*
import android.text.InputType
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.app.DatePickerDialog
import java.util.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // store user input
        val field_fn = findViewById<TextView>(R.id.fn)
        val field_em = findViewById<TextView>(R.id.em)
        val field_un = findViewById<TextView>(R.id.un)
        val cb_show = findViewById<CheckBox>(R.id.cb_show)
        val field_pw = findViewById<EditText>(R.id.pw)
        val cf_pw = findViewById<EditText>(R.id.cf_pw)
        val radg_gen = findViewById<RadioGroup>(R.id.rg_gen)
        val radb_male = findViewById<RadioButton>(R.id.rb_male)
        val radb_fem = findViewById<RadioButton>(R.id.rb_fem)
        val btn_bd = findViewById<Button>(R.id.btn_bd)
        val field_bd = findViewById<TextView>(R.id.view_bd)
        val btn_su = findViewById<Button>(R.id.btn_su)

            // to show and hide password
                // listener
                cb_show.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            field_pw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                            cf_pw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        } else {
                            field_pw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                            cf_pw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        }
                            field_pw.setSelection(field_pw.text.length)
                            cf_pw.setSelection(cf_pw.text.length)
                        }

            // for birthdate button
                // listener
            btn_bd.setOnClickListener {
                    val cal = Calendar.getInstance()

                    val year = cal.get(Calendar.YEAR)
                    val month = cal.get(Calendar.MONTH)
                    val day = cal.get(Calendar.DAY_OF_MONTH)

                    val datePicker = DatePickerDialog(this, { _, y, m, d ->
                        field_bd.text = "$d/${m + 1}/$y"
                    }, year, month, day)
                    datePicker.show()
                }

            // to show all input on UI (no validation)
                btn_su.setOnClickListener {
                    val user_fn = field_fn.text.toString()
                    val user_em = field_em.text.toString()
                    val user_un = field_un.text.toString()
                    val user_pw = field_pw.text.toString()
                    val user_bd = field_bd.text.toString()

                    val user_gd = when {
                        radb_male.isChecked -> "Male"
                        radb_fem.isChecked -> "Female"
                        else -> "No Selection"
                    }

                        Toast.makeText(
                            this,
                                "Profile Details:\n$user_fn\n$user_em\n$user_un\n$user_pw\n$user_bd\n$user_gd",
                            Toast.LENGTH_LONG
                        ) .show()
                }
    }
}
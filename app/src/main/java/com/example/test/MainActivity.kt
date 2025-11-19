package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val et1: EditText = findViewById(R.id.et1)
        val et2: EditText = findViewById(R.id.et2)
        val et3: EditText = findViewById(R.id.et3)
        val calculateBtn: Button = findViewById(R.id.btn)


        calculateBtn.setOnClickListener {
            val marks1 = et1.text.toString().toDoubleOrNull() ?: 0.0
            val marks2 = et2.text.toString().toDoubleOrNull() ?: 0.0
            val marks3 = et3.text.toString().toDoubleOrNull() ?: 0.0

            val cgpa = (marks1 + marks2 + marks3) / 30

            Toast.makeText(this, "CGPA: %.2f".format(cgpa), Toast.LENGTH_LONG).show()
        }
    }
}
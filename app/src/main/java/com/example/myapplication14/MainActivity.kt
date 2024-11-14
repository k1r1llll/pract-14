package com.example.myapplication14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val email = editTextEmail.text.toString()
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString()

            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("emailKey", email)
            intent.putExtra("nameKey", name) //ключ
            intent.putExtra("ageKey", age)
            startActivityForResult(intent, 1) //запуск интент
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextName = findViewById<EditText>(R.id.editTextName)
            val editTextAge = findViewById<EditText>(R.id.editTextAge)

            val updatedEmail = data?.getStringExtra("updatedEmail") //получаем данные
            val updatedName = data?.getStringExtra("updatedName")
            val updatedAge = data?.getStringExtra("updatedAge")

            if (updatedEmail != null) {
                editTextEmail.setText(updatedEmail + "*") // Пометка измененного поля
            }
            if (updatedName != null) {
                editTextName.setText(updatedName + "*") // Пометка измененного поля
            }
            if (updatedAge != null) {
                editTextAge.setText(updatedAge + "*") // Пометка измененного поля
            }
        }
    }
}

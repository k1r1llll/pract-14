package com.example.myapplication14

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val editTextEmail = findViewById<EditText>(R.id.editText1)
        val editTextName = findViewById<EditText>(R.id.editText2)
        val editTextAge = findViewById<EditText>(R.id.editText3)

        val arguments: Bundle? = intent.extras
        arguments?.let {
            editTextEmail.setText(it.getString("emailKey"))//с первого активи получаем во 2 ую активити результат котороый мы вписали в эдит текст
            editTextName.setText(it.getString("nameKey"))
            editTextAge.setText(it.getString("ageKey"))
        }

        val button = findViewById<Button>(R.id.buttonSave)

        button.setOnClickListener {
            val updatedEmail = editTextEmail.text.toString()
            val updatedName = editTextName.text.toString()
            val updatedAge = editTextAge.text.toString()

            // Создаем Intent для передачи данных обратно
            val resultIntent = Intent()
            resultIntent.putExtra("updatedEmail", updatedEmail)
            resultIntent.putExtra("updatedName", updatedName)
            resultIntent.putExtra("updatedAge", updatedAge)

            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Закрываем текущее Activity и возвращаемся к предыдущему
        }
    }
}

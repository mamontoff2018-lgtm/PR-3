package com.example.clickprocessinglab

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isModeA = true   // флаг для Задания 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ===================== ЗАДАНИЕ 1 =====================
        findViewById<Button>(R.id.btnTask1).setOnClickListener {
            Toast.makeText(this, "Покидов Матвей Юрьевич", Toast.LENGTH_SHORT).show()
        }

        // ===================== ЗАДАНИЕ 2 =====================
        val btnTask2 = findViewById<Button>(R.id.btnTask2)
        btnTask2.setOnClickListener {
            btnTask2.text = "Покидов М.Ю."
            Toast.makeText(this, "Текст кнопки изменён", Toast.LENGTH_SHORT).show()
        }

        // ===================== ЗАДАНИЕ 3 (три отдельных слушателя) =====================
        findViewById<Button>(R.id.btn1).setOnClickListener {
            Toast.makeText(this, "Нажата кнопка 1 — Покидов Матвей", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            Toast.makeText(this, "Нажата кнопка 2 — Покидов Матвей", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            Toast.makeText(this, "Нажата кнопка 3 — Покидов Матвей", Toast.LENGTH_SHORT).show()
        }

        // ===================== ЗАДАНИЕ 4 (один общий слушатель) =====================
        val commonListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.btn1 -> Toast.makeText(this, "Кнопка 1 (общий слушатель)", Toast.LENGTH_SHORT).show()
                R.id.btn2 -> {
                    (v as Button).text = "Покидов"
                    Toast.makeText(this, "Текст кнопки 2 изменён", Toast.LENGTH_SHORT).show()
                }
                R.id.btn3 -> Toast.makeText(this, "Кнопка 3 (общий слушатель)", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btn1).setOnClickListener(commonListener)
        findViewById<Button>(R.id.btn2).setOnClickListener(commonListener)
        findViewById<Button>(R.id.btn3).setOnClickListener(commonListener)

        // ===================== ЗАДАНИЕ 5 (переключение режимов) =====================
        findViewById<Button>(R.id.btnModeA).setOnClickListener {
            isModeA = true
            Toast.makeText(this, "Режим А включён", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnModeB).setOnClickListener {
            isModeA = false
            Toast.makeText(this, "Режим Б включён", Toast.LENGTH_SHORT).show()
        }

        // Кнопка 1 теперь реагирует по-разному в зависимости от режима
        findViewById<Button>(R.id.btn1).setOnClickListener {
            if (isModeA) {
                Toast.makeText(this, "Режим А: Покидов Матвей", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Режим Б: Группа ИНС-б-о-24-1", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
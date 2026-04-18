package com.kizima.intentapp_kizima

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnMap = findViewById<Button>(R.id.btnMap)
        val btnShare = findViewById<Button>(R.id.btnShare)


        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74951234567"))

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Нет приложения для звонка", Toast.LENGTH_SHORT).show()
            }
        }

        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("contact@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Обращение")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Нет почтового приложения", Toast.LENGTH_SHORT).show()
            }
        }

        btnMap.setOnClickListener {
            val geoUri = Uri.parse("geo:0,0?q=60.0237,30.2289(Наш офис)")
            val intent = Intent(Intent.ACTION_VIEW, geoUri)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Нет приложения карт", Toast.LENGTH_SHORT).show()
            }
        }

        btnShare.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Контакт: +7 (495) 123-45-67, contact@example.com")
            }

            val chooser = Intent.createChooser(sendIntent, "Поделиться через")
            startActivity(chooser)
        }
    }
}
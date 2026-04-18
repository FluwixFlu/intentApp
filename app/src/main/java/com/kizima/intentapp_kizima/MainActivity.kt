package com.kizima.intentapp_kizima

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private fun openIntentOrToast(intent: Intent, errorText: String) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnMap = findViewById<Button>(R.id.btnMap)
        val btnShare = findViewById<Button>(R.id.btnShare)

        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74951234567"))
            openIntentOrToast(intent, "Нет приложения для звонка")
        }

        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:contact@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "Обращение")
            }
            openIntentOrToast(intent, "Нет почтового приложения")
        }



}
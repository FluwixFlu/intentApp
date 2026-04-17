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


}
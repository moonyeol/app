package com.example.recolap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button1.setOnClickListener {
            val intent = Intent(this, searchscreen::class.java)
            startActivity(intent)

        button4.setOnClickListener {
            val intent = Intent(this, gamescreen::class.java)
            startActivity(intent)

        button5.setOnClickListener {
            val intent = Intent(this, studyscreen::class.java)
            startActivity(intent)

        button5.setOnClickListener {
            val intent = Intent(this, searchscreen::class.java)
            startActivity(intent)





        }
    }
}

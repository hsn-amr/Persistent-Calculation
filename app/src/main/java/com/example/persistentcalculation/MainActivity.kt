package com.example.persistentcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById<TextView>(R.id.tv)
        val etDouble = findViewById<EditText>(R.id.etDouble)
        val etFloat = findViewById<EditText>(R.id.etFloat)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            if(etDouble.text.isNotEmpty() && etFloat.text.isNotEmpty()){
                tv.text = "${etDouble.text.toString().toDouble() * etFloat.text.toString().toFloat()}"
            }else{
                Toast.makeText(this, "Please, Enter Numbers", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("tv", tv.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tv.text = savedInstanceState.getString("tv")
    }
}
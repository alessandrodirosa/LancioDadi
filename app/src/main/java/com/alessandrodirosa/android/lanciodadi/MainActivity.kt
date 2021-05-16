package com.alessandrodirosa.android.lanciodadi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lanciaDadoButton : Button = findViewById(R.id.lancioDadoButton)
        lanciaDadoButton.setOnClickListener{
            lanciaDado()
        }
    }

    private fun lanciaDado() {
        val myDado = Dado()
        Toast.makeText(this,"Dado lanciato!",Toast.LENGTH_SHORT).show()
        val valoreDadoTxt : TextView = findViewById(R.id.valoreDadoTxt)
        valoreDadoTxt.text = myDado.lancia().toString()
    }
}

class Dado(private val facce:Int = 6){
    fun lancia(): Int = (1..facce).random()
}
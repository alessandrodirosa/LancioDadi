package com.alessandrodirosa.android.lanciodadi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        lanciaDado()
    }

    private fun lanciaDado() {
        val myDado = Dado()
        val dadoImage :ImageView = findViewById(R.id.dadoImageView)
        val numeroEstratto = myDado.lancia()
        val drawableImageResource = when (numeroEstratto){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else ->  R.drawable.dice_6
        }
        dadoImage.setImageResource(drawableImageResource)
        dadoImage.contentDescription = numeroEstratto.toString()
        Toast.makeText(this,"Dado lanciato!",Toast.LENGTH_SHORT).show()
    }
}

class Dado(private val facce:Int = 6){
    fun lancia(): Int = (1..facce).random()
}
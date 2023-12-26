package com.cjl.evaluacioni_cjl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class CalcContrato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_contrato)

        // Definición variable y asociación para volver a pantalla inicio
        val btnInicio2 = findViewById<Button>(R.id.btnInicio2)
        btnInicio2.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity( intent)
        }

        // Definición variable y funcionalidad de Calculo Sueldo

     //   val btnCalcCtto = findViewById<Button>(R.id.btnCalcCtto)
       // btnCalcCtto.setOnClickListener(
         //   fun calcSueldoContrato ()
       // )

    }

}
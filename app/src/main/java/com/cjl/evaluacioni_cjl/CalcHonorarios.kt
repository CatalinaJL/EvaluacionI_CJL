package com.cjl.evaluacioni_cjl

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class CalcHonorarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcHonorariosScreen()
        }
    }
}


@Preview
@Composable
fun CalcHonorariosScreen() {

    val context= LocalContext.current
    var sueldoBruto by remember { mutableStateOf("0") }
    var sueldoFinal = 0.0
    var sueldoString = " "


    Column(
      modifier = Modifier
          .fillMaxSize()
          .background(Color.LightGray),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
  ){
      Text("En esta pantalla se calcula el sueldo a honorarios")

      Spacer(modifier = Modifier.height(40.dp))

      Text(text = "Ingrese el sueldo imponible del trabajador:")
      Spacer(modifier = Modifier.height(15.dp))
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
        )


        Spacer(modifier = Modifier.height(15.dp))

      Button(onClick = {
          /*Acá debe ir el la función que va a permitir
            calcular el sueldo a honorarios*/
          sueldoFinal = calcSueldoHonorario(sueldoBruto)
          Log.v("Calculo Honorarios","Sueldo al hacer click" + sueldoFinal.toString())
          sueldoString = sueldoFinal.toString()
          Log.v("Calculo Honorarios", "sueldo en string" +  sueldoString)

        }){
          Text(text = "Calcular Sueldo")
          
      }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "El sueldo liquido es de $sueldoString")
        Log.v("Calculo Honorarios", "El sueldo que se va a mostrar es: " + sueldoString)



      Spacer(modifier = Modifier.height(120.dp))




      Button(onClick = {
          /* Este botón permite ir al inicio para seleccionar
          * otra opcippon de cálculo*/
          Log.v("Calculo Honorarios", "Volviendo a inicio")
          val intent = Intent(context,MainActivity::class.java )
          context.startActivity(intent)
      }) {
          Text(text= "<- Volver"
          )
      }
  }
}



fun calcSueldoHonorario(sueldoBruto:String): Double {
    Log.v("Calculo Honorarios", sueldoBruto)
    var montRetencion = sueldoBruto.toInt() * 0.13
    Log.v("Calculo Honorarios", montRetencion.toString())
    var sueldoLiquido = sueldoBruto.toInt() - montRetencion
    Log.v("Calculo Honorarios", sueldoLiquido.toString())

    return sueldoLiquido
}
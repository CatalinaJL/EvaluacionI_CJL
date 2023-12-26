package com.cjl.evaluacioni_cjl

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cjl.evaluacioni_cjl.ui.theme.EvaluacionI_CJLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           HomeScreen()
        }
    }
}



@Preview()
@Composable
fun HomeScreen() {

    val context = LocalContext.current
    Column( 
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Bienvenidos a CalcRemuneracion")

        Spacer(modifier = Modifier.height(80.dp))
        
        Button(
            onClick = {
                val intent = Intent(context, CalcHonorarios::class.java)
                context.startActivity(intent)}
        ) {
            Text("Cálculo Honorarios")
        }
        Button(onClick = {
            val intent = Intent(context, CalcContrato::class.java)
            context.startActivity(intent)
        }) {
            Text("Cálculo Contratos")
        }
       
    }
}
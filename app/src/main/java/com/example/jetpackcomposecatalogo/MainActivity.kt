package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetPackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyBox("Android")
                    //MyRow()
                    //MyComplexLayout()
                    MyStateExample()
                }
            }
        }
    }
}

/*@Composable
fun MyStateExample(){

    //remember, para gurdar los estados
    //rememberSaveable para guardar incluso si se gira el dispositivo
    var counter = rememberSaveable{mutableStateOf(0)}

    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)

    {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "pulsar")
        }
        Text(text ="He sido pulsado ${counter.value} veces")
    }
}*/
@Composable
fun MyStateExample(){

    //remember, para gurdar los estados
    //rememberSaveable para guardar incluso si se gira el dispositivo
    //para usar el by es necesario mantener el VAR
    var counter by rememberSaveable{mutableStateOf(0)}

    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)

    {
        Button(onClick = { counter += 1 }) {
            Text(text = "pulsar")
        }
        Text(text ="He sido pulsado ${counter} veces")
    }
}

@Composable
fun MyColumn() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejamplo1", modifier = Modifier.background(Color.Red))
        Text(text = "Ejamplo2", modifier = Modifier.background(Color.Black))
        Text(text = "Ejamplo3", modifier = Modifier.background(Color.Cyan))
        Text(text = "Ejamplo4", modifier = Modifier.background(Color.Blue))
    }

}

@Composable
fun MyRow(){
    /*Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2")
        Text(text = "Ejemplo 3")
    }*/

    Row (
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())){
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 5", modifier = Modifier.width(100.dp))


        /*Text(text = "Ejemplo 1", modifier = Modifier.weight(1f))
        Text(text = "Ejemplo 2", modifier = Modifier.weight(1f))
        Text(text = "Ejemplo 3", modifier = Modifier.weight(1f))*/
    }
}

@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ){
            Text(text = "Ejemplo 1")

        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)){
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red), contentAlignment = Alignment.Center
            ){
                Text(text = "Ejemplo 2")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green), contentAlignment = Alignment.Center
            ){
                Text(text = "Ejemplo 3")
            }
        }
        MySpacer(size = 50)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ){
            Text(text = "Ejemplo 4")

        }

    }
}

@Composable
fun MySpacer(size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "ESTO ES UN EJEMPLO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeCatalogoTheme {
        //MyBox("Android")
        //MyColumn()
        //MyRow()
        //MyComplexLayout()
        MyStateExample()
    }
}
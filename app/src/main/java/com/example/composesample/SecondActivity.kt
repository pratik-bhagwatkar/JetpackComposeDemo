package com.example.composesample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                ButtonDemo()

            }
        }
    }
}

@Composable
fun BoxExample1(){
    Box(
        modifier = Modifier
            .background(color = Color.Green)
            .size(200.dp, 300.dp)
    ){
        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .size(120.dp, 100.dp)
                .align(Alignment.TopEnd)
        ){

        }

        Text(
            text = "Hello World",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        )


    }


}

@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ){
        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.TopStart),
            text = "TopStart"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.TopCenter),
            text = "TopCenter"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.TopEnd),
            text = "TopEnd"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.CenterStart),
            text = "CenterStart"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.Center),
            text = "Center"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.CenterEnd),
            text = "CenterEnd"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.BottomStart),
            text = "BottomStart"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.BottomCenter),
            text = "BottomCenter"

        )

        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(5.dp)
                .align(Alignment.BottomEnd),
            text = "BottomEnd"
        )
    }

}

@Composable
fun BoxExample3(){
    Box (
        modifier = Modifier
            .background(color = Color.DarkGray)
    ){

        Image(
            painter = painterResource(id = R.drawable.jungle),
            contentDescription = "jungle",
        )

        Text(
            text = "Jungle Safari",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(5.dp)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Red,
                backgroundColor = Color.Yellow
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(5.dp)
        ) {
            Text(
                text = "Add to Cart",
            )

        }
    }
}

@Composable
fun ButtonDemo(){
    val context= LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context,"Button Clicked...", Toast.LENGTH_LONG).show()
            Log.i("tagii","Button Clicked")
        }
    ) {
        Text(text = "Add to Cart")
    }

    Button(
        onClick = {
            Toast.makeText(context,"Button Clicked...", Toast.LENGTH_LONG).show()
            Log.i("tagii","Button Clicked")
        },
        enabled = false
    ) {
        Text(text = "Add to Cart")
    }

    TextButton(
        onClick = {
            Toast.makeText(context,"TextButton Clicked...", Toast.LENGTH_LONG).show()
            Log.i("tagii","Text Button Clicked")
        }
    ) {
        Text(text = "Add to Cart")
    }

    OutlinedButton(
        onClick = {
            Toast.makeText(context,"OutlinedButton Clicked...", Toast.LENGTH_LONG).show()
            Log.i("tagii","OutlinedButton Clicked")
        }
    ) {
        Text(text = "Add to Cart")
    }

    IconButton(
        onClick = {
            Toast.makeText(context,"IconButton Clicked...", Toast.LENGTH_LONG).show()
            Log.i("tagii","IconButton Clicked")
        }
    ) {
        Icon(
            Icons.Filled.Refresh,
            contentDescription ="Refresh Button",
            tint = Color.Red,
            modifier = Modifier.size(60.dp)

        )
    }

    Button(
        onClick = {
            Toast.makeText(context,"Button Clicked...", Toast.LENGTH_LONG).show()
            Log.i("tagii","Button Clicked")
        },
        shape = RectangleShape
    ) {
        Text(text = "Add to Cart")
    }

}
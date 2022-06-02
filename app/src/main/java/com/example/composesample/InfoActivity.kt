package com.example.composesample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.model.TvShow
import com.example.composesample.ui.theme.ComposeSampleTheme

class InfoActivity : ComponentActivity() {

    companion object{
        private const val tvShowId="tv"
        fun intent(context: Context,tvShow: TvShow)=
            Intent(context,InfoActivity::class.java).apply {
                putExtra(tvShowId,tvShow)
            }
        }

    private val tvShow : TvShow by lazy {
        intent?.getSerializableExtra(tvShowId) as TvShow
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewMoreInfo(tvShow = tvShow)
        }
    }
}

@Composable
fun ViewMoreInfo(tvShow: TvShow){

    val scrollState= rememberScrollState()
    Card (
        modifier = Modifier
            .padding(5.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(corner = CornerSize(5.dp))
     ){

        Column (
             modifier = Modifier
                 .fillMaxWidth()
                 .verticalScroll(scrollState)
                 .padding(5.dp)
        ){

            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.h5
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = tvShow.overview,
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Year : ${tvShow.year.toString()}",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "IMDB : ${tvShow.rating.toString()}",
                style = MaterialTheme.typography.h6
            )
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        Greeting("Android")
    }
}
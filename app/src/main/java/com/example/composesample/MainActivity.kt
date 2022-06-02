package com.example.composesample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.model.TvShow
import com.example.composesample.data.TvShowList


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayTvShoe{
                Log.i("tagii","item clicked $it")
                startActivity(InfoActivity.intent(this,it))
            }
        }
    }
}

/*@Composable
fun ScrollableColumnDemo(){
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
            ){
        for (i in 1..100){
          Text(
              text = "User No: $i",
              style = MaterialTheme.typography.h6,
              modifier = Modifier.padding(7.dp)
          )
            Divider(
                color = Color.DarkGray,
                thickness = 1.dp
            )
        }
    }
}*/

/*@Composable
fun LazyColumnDemo(){

    LazyColumn{
          items(100) {
              Text(
                  text = "User No: ${it+1}",
                  style = MaterialTheme.typography.h6,
                  modifier = Modifier.padding(7.dp)
              )
              Divider(
                  color = Color.DarkGray,
                  thickness = 1.dp
              )
          }
    }
}

@Composable
fun LazyColumnDemo2(selectedItem:(String)->(Unit)){
    LazyColumn{
        items(100) {
            Text(
                text = "User No: ${it+1}",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(7.dp)
                    .clickable {
                        selectedItem("${it + 1} Selected")
                    }
            )
            Divider(
                color = Color.DarkGray,
                thickness = 1.dp
            )
        }
    }
}*/

@Composable
fun DisplayTvShoe(seletedItem:(TvShow)->(Unit)){

    val tvShows=remember{TvShowList.tvShows}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 5.dp,vertical = 5.dp)
    ){
       this.items(
           items=tvShows,
           itemContent={
               TvShowListItem(tvShow = it, selectedItem = seletedItem)
           }
       )
    }
}

@Composable
fun TvShowListItem(tvShow: TvShow, selectedItem: (TvShow) -> Unit){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row (
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically,
         ){

            TvShowImage(tvShow = tvShow)
            Column {
                Text(text = tvShow.name,style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = tvShow.overview,
                    style = MaterialTheme.typography.body1,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(3.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = tvShow.year.toString(),style = MaterialTheme.typography.h6)
                    Text(text = tvShow.rating.toString(),style = MaterialTheme.typography.h6)
                }
            }
        }
    }
}

@Composable
fun TvShowImage(tvShow: TvShow){
    Image(
        painter = painterResource(id = tvShow.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(5.dp)
            .height(100.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(5.dp)))
    )
}


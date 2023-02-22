package com.example.composeact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeact.compose.TVShowListItem
import com.example.composeact.ui.theme.ComposeActTheme
import com.example.composerecyclerview.data.TvShowList
import com.example.composerecyclerview.model.TvShow

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }

            }
            //ScollableColumnDemo()
//            //LazyColumnsDemo()
//            LazyColumnsDemoLambda{
//                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
//            }
            DisplayTVShows(){
//                Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()
            startActivity(InfoActivity.intent(this,it))
            }
        }
    }

//    @Composable
//    fun ScollableColumnDemo(){
//        val scrollState = rememberScrollState()
//        Column(modifier = Modifier.verticalScroll(scrollState)) {
//            for(i in 1..100){
//                Text("User Name $i",
//                style = MaterialTheme.typography.h3,
//                modifier = Modifier.padding(10.dp)
//                    )
//                Divider(color = Color.Black, thickness = 5.dp)
//        }
//        }
//    }
//
//    @Composable
//    fun LazyColumnsDemo(){
//        LazyColumn{
//            items (100){
//                Text("User Name $it",
//                    style = MaterialTheme.typography.h3,
//                    modifier = Modifier.padding(10.dp)
//                )
//                Divider(color = Color.Black, thickness = 5.dp)
//            }
//        }
//    }
//
//    @Composable
//    fun LazyColumnsDemoLambda(selectedItem:(String) -> (Unit)){
//        LazyColumn{
//            items (100){
//                Text("User Name $it",
//                    style = MaterialTheme.typography.h3,
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .clickable { selectedItem("$it Selected") }
//                )
//                Divider(color = Color.Black, thickness = 5.dp)
//            }
//        }
//    }

    @Composable
    fun DisplayTVShows(selectedItem: (TvShow) -> Unit) {
        val tvShows = remember { TvShowList.tvShows }
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp) ) {
            items(
                items = tvShows,
                itemContent = {
                    TVShowListItem(tvShow = it, selectedItem)
                }
            )
        }
    }
}

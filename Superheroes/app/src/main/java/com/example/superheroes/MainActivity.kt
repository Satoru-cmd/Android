package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.ui.theme.SuperheroesTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp


data class Superhero(val name: String, val imageResId: Int)
val superheroes = listOf(
    Superhero("Superman", R.drawable.android_superhero1),
    Superhero("Batman", R.drawable.android_superhero2),
    Superhero("Wonder Woman", R.drawable.android_superhero3),
    Superhero("Flash", R.drawable.android_superhero4)
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                LazyColumn(

                ) {
                    items(superheroes) { superhero ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .animateContentSize()
                                ,
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 8.dp
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .animateContentSize()
                                    .align(Alignment.CenterHorizontally),
                            ) {
                                Image(
                                    painter = painterResource(id = superhero.imageResId),
                                    contentDescription = null,
                                    modifier = Modifier.height(200.dp),
                                )
                                Text(
                                    text = superhero.name,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun SuperheroInfo(modifier: Modifier = Modifier) {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
    }
}


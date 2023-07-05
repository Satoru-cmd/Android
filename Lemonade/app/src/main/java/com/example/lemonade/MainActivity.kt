package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun LemonTextAndImage(textStringResourceId: Int, 
                      imagePainterResourceId: Int,
                      onImageClick: () -> Unit,
                      modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = textStringResourceId))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = imagePainterResourceId),
            contentDescription = stringResource(id = textStringResourceId),
            //modifier = Modifier.clickable { onClick = onImageClick } // 次のSTEPに進める
        )
        Button(onClick = onImageClick) {
            Text(text = "push!")
        }
    }
}

@Composable
fun LemonadeImage(modifier: Modifier = Modifier) {

    // レモネード作成STEP
    var currentCount by remember{mutableStateOf(1)}
    // レモンを絞った回数
    var lemonSqueezeCount by remember{mutableStateOf(0)}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        when (currentCount) {
            1 -> {
                LemonTextAndImage(
                    textStringResourceId = R.string.selectLemon,
                    imagePainterResourceId = R.drawable.lemon_tree,
                    onImageClick = {
                        currentCount = 2
                    }
                )
                lemonSqueezeCount = (2..4).random()
            }

            2 -> {
                LemonTextAndImage(
                    textStringResourceId = R.string.tapLemon,
                    imagePainterResourceId = R.drawable.lemon_squeeze,
                    onImageClick = {
                        lemonSqueezeCount--
                        if (lemonSqueezeCount == 0) {
                            currentCount = 3
                        }
                    }
                )
            }

            3 -> {
                LemonTextAndImage(
                    textStringResourceId = R.string.drinkLemonade,
                    imagePainterResourceId = R.drawable.lemon_drink,
                    onImageClick = {
                        currentCount = 4
                    }
                )
            }
            4 -> {
                LemonTextAndImage(
                    textStringResourceId = R.string.tapGlass,
                    imagePainterResourceId = R.drawable.lemon_restart,
                    onImageClick = {
                        currentCount = 1
                    }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
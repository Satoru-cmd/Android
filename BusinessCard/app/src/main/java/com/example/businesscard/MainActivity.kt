package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    //BusinessCard()
                    BusinessCardProfile(name = getString(R.string.name), title = getString(R.string.title))
                    BusinessCardOtherInfo(tel = getString(R.string.tel), sns = getString(R.string.sns), email = getString(R.string.email))

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun BusinessCard() {
    val name = stringResource(id = R.string.name)
    val title = stringResource(id = R.string.title)
    val tel = stringResource(id = R.string.tel)
    val sns = stringResource(id = R.string.sns)
    val email = stringResource(id = R.string.email)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        BusinessCardProfile(name = name, title = title)
        BusinessCardOtherInfo(tel = tel, sns = sns, email = email)
    }
}

/**
 * 名前などの表示エリア
 */
@Composable
fun BusinessCardProfile(name: String,title: String,modifier: Modifier = Modifier) {

    val image = painterResource(id = R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier.size(100.dp),

        )
        Text(
            text = name,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
            //textAlign = TextAlign.Center,
            //modifier = modifier.fillMaxWidth()
        )
        Text(
            text = title,
            fontStyle = FontStyle.Italic,
            modifier = modifier.padding(top = 10.dp)
        )
    }
}

/**
 * TELなどの情報エリア
 */
@Composable
fun BusinessCardOtherInfo(tel: String, sns: String, email: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .border(width = 1.dp,color = Color.Black)
        ) {
            Icon(Icons.Rounded.Call, contentDescription = null)
            Text(
                text = tel,
                modifier = modifier.padding(start = 5.dp),
                fontSize = 25.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
                .border(width = 1.dp,color = Color.Black)
        ) {
            Icon(Icons.Rounded.Share, contentDescription = null)
            Text(
                text = sns,
                modifier = modifier.padding(start = 5.dp),
                fontSize = 25.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .border(width = 1.dp,color = Color.Black)
        ) {
            Icon(Icons.Rounded.Email, contentDescription = null)
            Text(
                text = email,
                modifier = modifier.padding(start = 5.dp),
                fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardOtherInfo(
            tel = "satoru",
            sns = "ss",
            email = "saaaa"
        )

    }
}
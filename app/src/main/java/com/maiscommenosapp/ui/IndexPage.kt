package com.maiscommenosapp.ui

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maiscommenosapp.LoginMercadinho
import com.maiscommenosapp.LoginOng
import com.maiscommenosapp.R

@Preview(showBackground = true)
@Composable
fun IndexPage(modifier: Modifier = Modifier) {

    val activity = LocalContext.current as? Activity
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize().background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Bem-vindo ao MaisComMenosApp!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = modifier.size(24.dp))
        Row(modifier = modifier) {
            Button(
                onClick = {
                    activity?.startActivity(
                        Intent(activity, LoginMercadinho::class.java).setFlags(
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                    //Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                }
            ) {
                Text("Mercadinho")
            }

        }
        Row(modifier = modifier) {
            Button(
                onClick = {
                    activity?.startActivity(
                        Intent(activity, LoginOng::class.java).setFlags(
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                    //Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                }
            ) {
                Text("ONG")
            }

        }
        Row(modifier = modifier) {
            Button(
                onClick = { activity?.finish() }
            ) {
                Text("Sair")
            }
        }
    }
}
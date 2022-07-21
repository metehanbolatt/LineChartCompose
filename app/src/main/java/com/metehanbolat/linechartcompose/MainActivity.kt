package com.metehanbolat.linechartcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.metehanbolat.linechartcompose.ui.theme.LineChartComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LineChartComposeTheme {
                val data = listOf(
                    Pair(6, 111.45),
                    Pair(7, 111.0),
                    Pair(8, 113.45),
                    Pair(9, 112.25),
                    Pair(10, 116.45),
                    Pair(11, 113.35),
                    Pair(12, 118.65),
                    Pair(13, 110.15),
                    Pair(14, 113.05),
                    Pair(15, 114.25),
                    Pair(16, 116.35),
                    Pair(17, 117.45),
                    Pair(18, 112.65),
                    Pair(19, 115.45),
                    Pair(20, 111.85)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    LineChart(
                        data = data,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .align(CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(40.dp))
                    QuadLineChart(
                        data = data,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .align(CenterHorizontally)
                    )
                }
            }
        }
    }
}


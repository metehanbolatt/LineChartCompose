package com.metehanbolat.linechartcompose

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.sp
import kotlin.math.round
import kotlin.math.roundToInt

@Composable
fun LineChart(
    ourData: List<OurData> = emptyList(),
    modifier: Modifier = Modifier,
    graphColor: Color = Color.Green
) {
    val spacing = 100f
    val transparentGraphColor = remember { graphColor.copy(alpha = 0.5f) }

    val upperValue = remember { (ourData.maxOfOrNull { it.close }?.plus(1))?.roundToInt() ?: 0 }
    val lowerValue = remember { ourData.minOfOrNull { it.close }?.toInt() ?: 0 }

    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Canvas(modifier = modifier) {
        val spacePerHour = (size.width - spacing) / ourData.size
        (0 until ourData.size - 1 step 2).forEach { i ->
            val data = ourData[i]
            val hour = data.date.hour
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    hour.toString(),
                    spacing + i * spacePerHour,
                    size.height - 5,
                    textPaint
                )
            }
        }
        val priceStep = (upperValue - lowerValue) / 5f
        (0..5).forEach { i ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    round(lowerValue + priceStep * i).toString(),
                    30f,
                    size.height - spacing - i * size.height / 5f,
                    textPaint
                )
            }
        }
    }

}
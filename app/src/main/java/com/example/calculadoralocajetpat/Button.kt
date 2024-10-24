package com.example.calculadoralocajetpat

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(displayText: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Cyan),
        modifier = Modifier
            .size(80.dp)
    ) {
        Text(text = displayText, fontSize = 24.sp, color = Color.White)
    }
}

package com.example.calculadoralocajetpat

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen() {
    val state = remember { Estado() }
    val buttons = listOf(
        listOf("1", "2", "3", "+"),
        listOf("4", "6", "7", "-"),
        listOf("8", "9", "0", "*"),
        listOf("C", "=", "/", "AC")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Color.Cyan)
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(text = state.expression.value, fontSize = 32.sp, color = Color.Black, modifier = Modifier.padding(8.dp))
            Text(text = state.result.value, fontSize = 32.sp, color = Color.Black, modifier = Modifier.padding(8.dp))
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            buttons.forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    row.forEach { symbol ->
                        CalculatorButton(displayText = symbol, onClick = {
                            when (symbol) {
                                "=" -> state.calculateResult()
                                "C", "AC" -> state.clear()
                                else -> state.onNumberClick(handleNumberClick(symbol))
                            }
                        })
                    }
                }
            }
        }
    }
}

fun handleNumberClick(symbol: String): String {
    return when (symbol) {
        "1" -> "3"
        "2" -> "4"
        "3" -> "8"
        "4" -> "0"
        "6" -> "9"
        "7" -> "2"
        "8" -> "1"
        "9" -> "7"
        "0" -> "6"
        else -> symbol
    }
}

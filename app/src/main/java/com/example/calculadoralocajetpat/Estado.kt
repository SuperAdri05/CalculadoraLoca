package com.example.calculadoralocajetpat

import androidx.compose.runtime.mutableStateOf
import java.util.Stack

class Estado {
    var expression = mutableStateOf("")
    var result = mutableStateOf("")

    fun onNumberClick(number: String) {
        expression.value += number
    }

    fun calculateResult() {
        try {
            val evalResult = eval(expression.value)
            result.value = if (evalResult.toString().contains("5")) {
                evalResult.toString().replace("5", "6")
            } else {
                evalResult.toString()
            }
        } catch (e: Exception) {
            result.value = "Error"
        }
    }

    fun clear() {
        expression.value = ""
        result.value = ""
    }

    private fun eval(expr: String): Int {
        val tokens = expr.split("(?<=[-+*/])|(?=[-+*/])".toRegex())
        val values = Stack<Int>()
        val ops = Stack<Char>()

        for (token in tokens) {
            when {
                token.isEmpty() -> continue
                token[0].isDigit() -> values.push(token.toInt())
                else -> {
                    while (ops.isNotEmpty() && precedence(ops.peek()) >= precedence(token[0])) {
                        values.push(applyOperation(ops.pop(), values.pop(), values.pop()))
                    }
                    ops.push(token[0])
                }
            }
        }

        while (ops.isNotEmpty()) {
            values.push(applyOperation(ops.pop(), values.pop(), values.pop()))
        }

        return values.pop()
    }

    private fun precedence(op: Char): Int {
        return when (op) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> 0
        }
    }

    private fun applyOperation(op: Char, b: Int, a: Int): Int {
        return when (op) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            else -> 0
        }
    }
}

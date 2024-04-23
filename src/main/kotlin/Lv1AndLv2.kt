package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

class Lv1AndLv2 {
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tempBr = br.readLine().split(" ")
    val num1 = tempBr[0].toInt()
    val num2 = tempBr[2].toInt()
    var operator = tempBr[1]

    when (operator) {
        "+" -> {
            println(num1 + num2)
        }

        "-" -> {
            println(num1 - num2)
        }

        "*" -> {
            println(num1 * num2)
        }

        "/" -> {
            println(num1 / num2)
        }

        "%" -> {
            println(num1 % num2)
        }

        else -> {
            println("해당 값은 연산자가 아닙니다")
        }
    }
}
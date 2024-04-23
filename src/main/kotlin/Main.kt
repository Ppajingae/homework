package org.example

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    //readln
    println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tempBr = br.readLine().split(" ")
    val num1 = tempBr[0].toInt()
    val num2 = tempBr[2].toInt()
    var operator = tempBr[1]
    var i: Int = 0
    var tempNum:Int = 0

    while(operator != "="){
        var newNum: Int

        if(i == 0) {
            when (operator) {
                "+" -> {
                    val res = AddOperation().result(num1, num2)
                    tempNum += res
                    println(res)
                }

                "-" -> {
                    val res = SubstractOperation().result(num1, num2)
                    tempNum += res
                    println(res)
                }

                "*" -> {
                    val res = MultiplyOperation().result(num1, num2)
                    tempNum += res
                    println(res)
                }

                "/" -> {
                    val res = DivideOperation().result(num1, num2)
                    tempNum += res
                    println(res)
                }

                "%" -> {
                    val res = RemainOperation().result(num1, num2)
                    tempNum += res
                    println(res)
                }

                else -> {
                    println("해당 값은 연산자가 아닙니다")
                    break
                }
            }
        }else{
            val temp = br.readLine().split(" ")
            if(temp.size >= 3){
                println("겂울 다시 입력해주세요 (2번째 입력 시에는 (기호 숫자) 방식으로 입력 부탁드립니다)")
                continue
            }
            operator = temp[0]
            if(operator == "="){
                println("총 계산 값 $tempNum")
                break
            }
            newNum = temp[1].toInt()

            when (operator) {
                "+" -> {
                    tempNum = AddOperation().result(tempNum, newNum)
                    println(tempNum)
                }

                "-" -> {
                    tempNum = SubstractOperation().result(tempNum, newNum)
                    println(tempNum)
                }

                "*" -> {
                    tempNum = MultiplyOperation().result(tempNum, newNum)
                    println(tempNum)
                }

                "/" -> {
                    tempNum = DivideOperation().result(tempNum, newNum)
                    println(tempNum)
                }

                "%" -> {
                    tempNum = RemainOperation().result(tempNum, newNum)
                    println(tempNum)
                }

                else -> {
                    println("해당 값은 연산자가 아닙니다")
                    break
                }
            }
        }


        i++
    }

}

fun operatorFunction(isFirst: Boolean, num1:Int, operator:String, num2:Int, tempNumMain:Int){
    var tempNum = tempNumMain
    if(isFirst){
        when (operator) {
            "+" -> {
                tempNum += AddOperation().result(tempNum, num2)
                println(tempNum)
            }

            "-" -> {
                tempNum += SubstractOperation().result(tempNum, num2)
                println(tempNum)
            }

            "*" -> {
                tempNum += MultiplyOperation().result(tempNum, num2)
                println(tempNum)
            }

            "/" -> {
                tempNum += DivideOperation().result(tempNum, num2)
                println(tempNum)
            }

            "%" -> {
                tempNum += RemainOperation().result(tempNum, num2)
                println(tempNum)
            }

            else -> {
                println("해당 값은 연산자가 아닙니다")
            }
        }
    }

}
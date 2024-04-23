package org.example

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")

    //BufferedReader 가 코테 할때 조금더 빠른 걸 보여 줘서 쓰긴 썻는데 왜 빠른지 잘 모르 겠습니다
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
            tempNum += operatorFunction(true, num1, operator, num2, tempNum)
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

            tempNum = operatorFunction(false, tempNum, operator, newNum, tempNum)
        }


        i++
    }

}

fun operatorFunction(isFirst: Boolean, num1:Int, operator:String, num2:Int, tempNumMain:Int):Int {
    var tempNum = tempNumMain
    if(isFirst){
        when (operator) {
            "+" -> {
                tempNum += AddOperation().result(num1, num2)
                println(tempNum)
            }

            "-" -> {
                tempNum += SubstractOperation().result(num1, num2)
                println(tempNum)
            }

            "*" -> {
                tempNum += MultiplyOperation().result(num1, num2)
                println(tempNum)
            }

            "/" -> {
                tempNum += DivideOperation().result(num1, num2)
                println(tempNum)
            }

            "%" -> {
                tempNum += RemainOperation().result(num1, num2)
                println(tempNum)
            }

            else -> {
                println("해당 값은 연산자가 아닙니다")
            }
        }

        return tempNum
    }else {
        when (operator) {
            "+" -> {
                tempNum = AddOperation().result(num1, num2)
                println(tempNum)
            }

            "-" -> {
                tempNum = SubstractOperation().result(num1, num2)
                println(tempNum)
            }

            "*" -> {
                tempNum = MultiplyOperation().result(num1, num2)
                println(tempNum)
            }

            "/" -> {
                tempNum = DivideOperation().result(num1, num2)
                println(tempNum)
            }

            "%" -> {
                tempNum = RemainOperation().result(num1, num2)
                println(tempNum)
            }

            else -> {
                println("해당 값은 연산자가 아닙니다")
            }
        }
        return tempNum
    }

}
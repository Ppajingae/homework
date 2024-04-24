package org.example

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")

    //BufferedReader 가 코테 할때 조금더 빠른 걸 보여 줘서 쓰긴 썻는데 왜 빠른지 잘 모르 겠습니다
    //Validation 함수를 만들어서 검사하는 옵션으로 처리
    //계산을 처리하는 함수는 Main.kt에 정의
    val br = BufferedReader(InputStreamReader(System.`in`))

    //몇 번 연산 했는지 체크
    var i: Int = 0

    //연산을 여러번 했을 경우 저장할 변수
    var tempNum: Int = 0
    val tempBr = br.readLine().split(" ")
    var num1 = tempBr[0]
    var operatorString: String = tempBr[1]
    var num2 = tempBr[2]

    //숫자 검사 함수
    if(!numberValidator(num1,num2)){
        while(!numberValidator(num1,num2)){
            println("숫자만 다시 입력해주세요")
            val reBr = br.readLine().split(" ")
            num1 = reBr[0]
            num2 = reBr[1]
            numberValidator(num1,num2)
        }
    }

    //연산자 검사 함수
    var operator: Char = operatorValidator(operatorString, br, i)


    while (true){
        if(i == 0){
            tempNum += operatorFunction(true, num1.toInt(), operator, num2.toInt(), tempNum)
        }else{
            println("추가적으로 연산할 값을 연산자 숫자 순으로 입력해 주세요")
            println("ex >> + 5")
            val nextBr = br.readLine().split(" ")
            val newOperator = nextBr[0]
            operator = operatorValidator(newOperator, br, i)
            if(operator == '='){
                println("총 계산 값 $tempNum")
                break
            }
            val newNum = nextBr[1]
            numberValidator(newNum, "1")

            tempNum = operatorFunction(num1=tempNum, num2=newNum.toInt(), isFirst = false, operator = operator, tempNumMain = tempNum)
        }

        i++
    }




}

fun operatorValidator(operator: String, br: BufferedReader, count: Int): Char {
    if (count == 0) {
        for (i in operator) {
            if (i == '+' || i == '-' || i == '*' || i == '/' || i == '%') {
                return i
            } else {
                while (true) {
                    println("연산자를 다시 입력해주세요")
                    println("연산자는 최초 입력된 연산자로 계산이 됩니다")
                    println("최초 계산 시에는 = 을 사용할 수 없습니다")
                    var operatorResult = br.readLine().toString()
                    for (k in operatorResult) {
                        if (k == '+' || k == '-' || k == '*' || k == '/' || k == '%') {
                            return k
                        }
                    }
                }
            }
        }
    }else{
        for (i in operator) {
            if (i == '+' || i == '-' || i == '*' || i == '/' || i == '%' || i == '=') {
                return i
            } else {
                while (true) {
                    println("연산자를 다시 입력해주세요")
                    println("연산자는 최초 입력된 연산자로 계산이 됩니다")
                    var operatorResult = br.readLine().toString()
                    for (k in operatorResult) {
                        if (k == '+' || k == '-' || k == '*' || k == '/' || k == '%' || k == '=') {
                            return k
                        }
                    }
                }
            }
        }
    }



    return ' '
}

fun numberValidator(num1: String, num2:String):Boolean{
    try{
        num1.toInt()
        num2.toInt()
        return true
    }catch (e:NumberFormatException){
        return false
    }
}
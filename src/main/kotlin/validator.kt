package org.example

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    //몇 번 연산 했는지 체크
    var isFirstCalculationCheck = false
    var tempNumber: Int = 0

    val startCalculator = inputNumberOperatorValidator(bufferedReader, isFirstCalculationCheck)

    while (true){
        if(!isFirstCalculationCheck){
            tempNumber += operatorFunction(
                isFirst = isFirstCalculationCheck,
                num1= startCalculator[0].toInt(),
                num2= startCalculator[2].toInt(),
                operator = startCalculator[1],
                tempNumber = tempNumber
            )

            isFirstCalculationCheck = true
        }else{
            val nextCalculation = inputNumberOperatorValidator(bufferedReader,isFirstCalculationCheck)

            if (nextCalculation[1] == "="){
                println("총 계산 값 $tempNumber")
                break
            }

            tempNumber = operatorFunction(
                isFirst = isFirstCalculationCheck,
                num1= tempNumber,
                num2= nextCalculation[0].toInt(),
                operator = nextCalculation[1],
                tempNumber = tempNumber
            )


        }
    }

}

fun operatorValidator(operator: String, count: Boolean):Boolean {
    if (!count) {
        for (i in operator) {
            return i in arrayOf('+', '-', '*', '/' ,'%')
        }
    }else{
        for(i in operator) {
            return i in arrayOf('+', '-', '*', '/', '%', '=')
        }
    }

    return false
}

fun numberValidator(num1: String, num2:String, isFirstCalculationCheck: Boolean):Boolean{
    try{
        if(isFirstCalculationCheck){
            num1.toInt()
            return true
        }
        num1.toInt()
        num2.toInt()
        return true
    }catch (e:NumberFormatException){
        return false
    }
}

fun inputNumberOperatorValidator(bufferedReader: BufferedReader, isFirstCalculationCheck: Boolean):List<String> {
    val calculationNumberOperationList = ArrayList<String>()
    var isNumberAndOperator = false
    var firstNumber:String
    var operatorString: String
    var secondNumber:String

    while (!isNumberAndOperator) {
     try {
         if(!isFirstCalculationCheck){
             val tempArray = bufferedReader.readLine().split(" ")
             firstNumber = tempArray[0]
             operatorString = tempArray[1]
             secondNumber = tempArray[2]
         }else{
             val tempArray = bufferedReader.readLine().split(" ")
             operatorString  = tempArray[0]
             if (operatorString == "="){
                 firstNumber = "0"
             }else{
                 firstNumber = tempArray[1]
             }
             secondNumber = "0"
         }

         if (!numberValidator(firstNumber, secondNumber, isFirstCalculationCheck)) {
             println("숫자가 잘못 되었습니다")
             println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
             continue
         }

         if (!operatorValidator(operatorString, isFirstCalculationCheck)) {
             println("연산자가 잘못 되었습니다")
             println("연산자는 +, - , *, /, %, = 입력 가능힙니다")
             println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
             continue
         }
         calculationNumberOperationList.addAll(arrayListOf(firstNumber, operatorString, secondNumber))
         isNumberAndOperator = true
     }catch (e:IndexOutOfBoundsException){
         println(e)
         println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
     }


    }

    return calculationNumberOperationList
}

fun calculatorProcedure(){

}

package org.example

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")

    //BufferedReader 가 코테 할때 조금더 빠른 걸 보여 줘서 쓰긴 썻는데 왜 빠른지 잘 모르 겠습니다
    //while에 true를 넣고 중간에 break로 반복문 탈출 처리
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    //몇 번 연산 했는지 체크
    var i: Int = 0
    
    //연산을 여러번 했을 경우 저장할 변수
    var tempNum: Int = 0


    while (true) {
        try {
            //수 연산자 수 순으로 띄워쓰기 기준으로 입력
            val tempBr = br.readLine().split(" ")
            //1번째 연산 이후에 새로 담을 변수 지정
            var newNum: Int
            
            if (i == 0) {
                var num1 = tempBr[0].toInt()
                var num2 = tempBr[2].toInt()
                
                //연산자 검사 로직
                var operatorString: String = tempBr[1]
                var operator:Char = ' '
                
                //연산자를 String으로 받았으므로 최초 연산자만 뽑아오도록 설계
                for(j in 0 until operatorString.length) {
                    if(operatorString[j] == '+' || operatorString[j] == '-' || operatorString[j] == '*' || operatorString[j] == '/' || operatorString[j] == '%') {
                        operator = operatorString[j]
                    }
                }
                //위에 로직에서 연산자가 처리되지 않을 경우 연산자를 입력 받도록 설계
                while (operator == ' ') {
                    println("연산자를 다시 입력해주세요, 연산자는 최초 입력된 연산자로 계산이 됩니다")
                    var operatorResult = br.readLine().toString()
                    for (k in 0 until operatorResult.length) {
                        if (operatorResult[k] == '+' || operatorResult[k] == '-' || operatorResult[k] == '*' || operatorResult[k] == '/' || operatorResult[k] == '%') {
                            operator = operatorResult[k]
                        }
                    }
                }

                
                
                //임시 저장공간에 계산 값을 저장
                tempNum += operatorFunction(true, num1, operator, num2, tempNum)

            } else {
                var operatorString: String = tempBr[0]
                var operator:Char = ' '
                for(j in 0 until operatorString.length) {
                    if(operatorString[j] == '+' || operatorString[j] == '-' || operatorString[j] == '*' || operatorString[j] == '/' || operatorString[j] == '%' || operatorString[j] == '=') {
                        operator = operatorString[j]
                    }
                }
                while (operator == ' ') {
                    println("연산자를 다시 입력해주세요, 연산자는 최초 입력된 연산자로 계산이 됩니다")
                    var operatorResult = br.readLine().toString()
                    for (k in 0 until operatorResult.length) {
                        if (operatorResult[k] == '+' || operatorResult[k] == '-' || operatorResult[k] == '*' || operatorResult[k] == '/' || operatorResult[k] == '%' || operatorResult[k] == '=') {
                            operator = operatorResult[k]
                        }
                    }
                }
                
                //연산자가 = 일 경우 반복문 탈출
                if (operator == '=') {
                    println("총 계산 값 $tempNum")
                    break
                }
                newNum = tempBr[1].toInt()

                tempNum = operatorFunction(false, tempNum, operator, newNum, tempNum)
            }

            i++
        } catch (e: NumberFormatException) {
            
            //NumberFormatException 에 대한 Exception 처리
            println("숫자가 잘못 입력 되었습니다")
        }
    }

}


//계산을 처리 하는 함수
fun operatorFunction(isFirst: Boolean, num1:Int, operator:Char, num2:Int, tempNumMain:Int):Int {
    var tempNum = tempNumMain
    if(isFirst){
        when (operator) {
            '+' -> {
                tempNum += AddOperation().result(num1, num2)
                println(tempNum)
            }

            '-' -> {
                tempNum += SubstractOperation().result(num1, num2)
                println(tempNum)
            }

            '*' -> {
                tempNum += MultiplyOperation().result(num1, num2)
                println(tempNum)
            }

            '/' -> {
                tempNum += DivideOperation().result(num1, num2)
                println(tempNum)
            }

            '%' -> {
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
            '+' -> {
                tempNum = AddOperation().result(num1, num2)
                println(tempNum)
            }

            '-' -> {
                tempNum = SubstractOperation().result(num1, num2)
                println(tempNum)
            }

            '*' -> {
                tempNum = MultiplyOperation().result(num1, num2)
                println(tempNum)
            }

            '/' -> {
                tempNum = DivideOperation().result(num1, num2)
                println(tempNum)
            }

            '%' -> {
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

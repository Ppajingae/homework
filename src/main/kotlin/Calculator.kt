package org.example

abstract class Calculator{
    abstract fun result(num1:Int, num2:Int):Int
}

class AddOperation: Calculator() {
    override fun result(num1: Int,  num2: Int):Int {
        return num1 + num2
    }

}

class SubstractOperation: Calculator(){
    override fun result(num1: Int, num2: Int): Int {
       return num1 - num2
    }

}

class MultiplyOperation: Calculator(){
    override fun result(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}

class DivideOperation: Calculator(){
    override fun result(num1: Int, num2: Int): Int {
        return num1 / num2
    }
}

class RemainOperation: Calculator(){
    override fun result(num1: Int, num2: Int): Int {
       return num1 % num2
    }
}
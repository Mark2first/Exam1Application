package Stack2

import java.util.Stack
import java.util.HashMap
import java.lang.StringBuilder
import java.math.BigDecimal

fun main(){
    var str = "12.4 + 12.6"
    println(Utils2.calculateString(str).toString())
}

object Utils2 {
    fun calculateString(s: String): Double {
        val ss = s.split(" ".toRegex()).toTypedArray()
        val stackNum = Stack<Double>()
        val stackSym = Stack<String>()
        val priority = HashMap<String, Int>()
        priority["+"] = 0
        priority["-"] = 0
        priority["*"] = 1
        priority["/"] = 1
        priority["("] = 0
        for (i in ss.indices) {
            val s1 = ss[i]
            if (isNotDigit(s1)) {
                if (stackSym.empty()) {
                    stackSym.push(s1)
                } else if (s1 === ")") {
                    while (stackSym.peek() !== "(") {
                        calculateOne(stackNum, stackSym)
                    }
                    stackSym.pop()
                } else {
                    if (priority[s1]!! > priority[stackSym.peek()]!!) {
                        stackSym.push(s1)
                    } else {
                        while (priority[s1]!! <= priority[stackSym.peek()]!!) {
                            calculateOne(stackNum, stackSym)
                            if (stackSym.empty()) {
                                break
                            }
                        }
                    }
                }
            } else if (isDigit(s1)) {
                val sb = StringBuilder()
                sb.append(s1)
                stackNum.push(java.lang.Double.valueOf(sb.toString() + ""))
            }
        }
        while (!stackSym.empty()) {
            calculateOne(stackNum, stackSym)
        }
        return stackNum.pop()
    }

    fun calculateOne(stackNum: Stack<Double>, stackSym: Stack<String>) {
        val opertor = stackSym.pop()
        val num1 = stackNum.pop()
        val num2 = stackNum.pop()
        val b1 = BigDecimal(num1)
        val b2 = BigDecimal(num2)
        when (opertor) {
            "*" -> {
                val result = b2.multiply(b1).toDouble()
                stackNum.push(result)
            }
            "/" -> {
                val result1 = b2.divide(b1).toDouble()
                stackNum.push(result1)
            }
            "+" -> {
                val result2 = b2.add(b1).toDouble()
                stackNum.push(result2)
            }
            "-" -> {
                val result3 = b2.subtract(b1).toDouble()
                stackNum.push(result3)
            }
        }
    }

    fun isNotDigit(s: String?): Boolean {
        when (s) {
            "+" -> return true
            "-" -> return true
            "*" -> return true
            "/" -> return true
            "(" -> return true
        }
        return false
    }

    fun isDigit(s: String): Boolean {
        return if (s === "") false else true
    }
}
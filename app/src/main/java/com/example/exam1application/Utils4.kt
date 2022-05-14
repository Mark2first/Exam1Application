package Stack2

import java.util.Stack
import java.util.HashMap
import Stack2.Utils4
import java.lang.Exception
import java.lang.StringBuilder

object Utils4 {
    /**
     * 实现方法
     * @param s
     * @return
     */
    fun calculateString(s: String): Double? {

        // 字符串转为字符数组
        val ss = s.split(" ".toRegex()).toTypedArray()
        val stackNum = Stack<Double>()
        val stackSym = Stack<String>()
        val priority = HashMap<String, Int>()

        //定义运算符优先级
        priority["+"] = 0
        priority["-"] = 0
        priority["*"] = 1
        priority["/"] = 1
        priority["("] = -1
        return try {
            for (i in ss.indices) {
                val s1 = ss[i]
                if (isNotDigit(s1) && s1 !== ".") {  // 非数字
                    if (stackSym.empty()) {   // 符号栈为空则直接进栈
                        stackSym.push(s1)
                    } else {
                        if (s1 === "(") {   // 直接进栈
                            stackSym.push(s1)
                        } else if (s1 === ")") {
                            while (stackSym.peek() !== "(") {  //依次出栈进行运算直到栈顶元素为'('
                                calculateOne(stackNum, stackSym)
                            }
                            stackSym.pop()
                        } else {
                            if (priority[s1]!! > priority[stackSym.peek()]!!) {    // 当前运算符优先级大于符号栈顶运算符
                                stackSym.push(s1)
                            } else {  // 反之
                                while (priority[s1]!! <= priority[stackSym.peek()]!!) {
                                    calculateOne(stackNum, stackSym)
                                    if (stackSym.empty()) {
                                        break
                                    }
                                }
                                stackSym.push(s1)
                            }
                        }
                    }
                } else if (isDigit(s1)) {     // 数字直接进栈
                    val sb = StringBuilder()
                    sb.append(s1)
                    stackNum.push(java.lang.Double.valueOf(sb.toString() + ""))
                }
            }
            while (!stackSym.empty()) {  // 字符串数组进栈完毕，依次出栈进行运算，直到符号栈为空
                calculateOne(stackNum, stackSym)
            }
            stackNum.pop()
        } catch (e: Exception) {
            null
        }
    }

    /**
     * 计算：存放数字的栈出两个数，存放符号的栈出一个符号，进行计算并放入数字栈
     * @param stackNum
     * @param stackSym
     */
    fun calculateOne(stackNum: Stack<Double>, stackSym: Stack<String>) {
        val operator = stackSym.pop()
        val num1 = stackNum.pop()
        val num2 = stackNum.pop()
        when (operator) {
            "*" -> {
                val result = num2 * num1
                stackNum.push(result)
            }
            "/" -> {
                val result1 = num2 / num1
                stackNum.push(result1)
            }
            "+" -> {
                val result2 = num2 + num1
                stackNum.push(result2)
            }
            "-" -> {
                val result3 = num2 - num1
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
            ")" -> return true
        }
        return false
    }

    fun isDigit(s: String): Boolean {
        return if (s === "") false else true
    }
}
package Stack2

import java.util.Stack
import java.util.HashMap
import java.lang.StringBuilder
import java.util.EmptyStackException
import java.io.PrintWriter
import java.io.IOException
import java.io.StringWriter
import kotlin.Exception

fun main(){
    var ss = "12 + "
    try{
        var result = Utils3.calculateString(ss)
        if (result==null){
            println("its null")
        }else{
            println(result.toString())
        }
    }catch (e:Exception){
        println("值为空")
    }
}

object Utils3 {
    fun calculateString(s: String): Double? {
        val ss = s.split(" ".toRegex()).toTypedArray()
        val stackNum = Stack<Double>()
        val stackSym = Stack<String>()
        val priority = HashMap<String, Int>()
        priority["+"] = 0
        priority["-"] = 0
        priority["*"] = 1
        priority["/"] = 1
        priority["("] = 0
        return try {
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
            stackNum.pop()
        } catch (e: EmptyStackException) {
//            System.out.println("结果： e.getMessage()------"+e.getMessage());
//            System.out.println("结果： e.printStackTrace()--------"+getStackTraceInfo(e));
            null
        }
    }

    fun getStackTraceInfo(e: Exception): String {
        var sw: StringWriter? = null
        var pw: PrintWriter? = null
        return try {
            sw = StringWriter()
            pw = PrintWriter(sw)
            e.printStackTrace(pw) //将出错的栈信息输出到printWriter中
            pw.flush()
            sw.flush()
            sw.toString()
        } catch (ex: Exception) {
            "发生错误"
        } finally {
            if (sw != null) {
                try {
                    sw.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }
            }
            pw?.close()
        }
    }

    fun calculateOne(stackNum: Stack<Double>, stackSym: Stack<String>) {
        val opertor = stackSym.pop()
        val num1 = stackNum.pop()
        val num2 = stackNum.pop()
        when (opertor) {
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
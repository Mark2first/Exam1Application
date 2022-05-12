package com.example.exam1application

import Stack2.Utils2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // EditText获取
        var editText:EditText = findViewById(R.id.edittext)

        // 数字按钮获取
        var button0:Button = findViewById(R.id.btn0)
        var button1:Button = findViewById(R.id.btn1)
        var button2:Button = findViewById(R.id.btn2)
        var button3:Button = findViewById(R.id.btn3)
        var button4:Button = findViewById(R.id.btn4)
        var button5:Button = findViewById(R.id.btn5)
        var button6:Button = findViewById(R.id.btn6)
        var button7:Button = findViewById(R.id.btn7)
        var button8:Button = findViewById(R.id.btn8)
        var button9:Button = findViewById(R.id.btn9)
        var btnd:Button = findViewById(R.id.btnd)

        // 符号按钮获取
        var btnAdd:Button = findViewById(R.id.btnAdd)   // 加法
        var btnSub:Button = findViewById(R.id.btnSub)   // 减法
        var btnMul:Button = findViewById(R.id.btnMul)   // 乘法
        var btnDiv:Button = findViewById(R.id.btnDiv)   // 除法
        var btnAC:Button = findViewById(R.id.btnAC)     // 清零

        // 等于按钮
        var equal:Button = findViewById(R.id.equal)     //等于号

        button0.setOnClickListener{
            editText.setText(editText.text.toString() + button0.text.toString())
        }
        button1.setOnClickListener{
            editText.setText(editText.text.toString() + button1.text.toString())
        }
        button2.setOnClickListener{
            editText.setText(editText.text.toString() + button2.text.toString())
        }
        button3.setOnClickListener{
            editText.setText(editText.text.toString() + button3.text.toString())
        }
        button4.setOnClickListener{
            editText.setText(editText.text.toString() + button4.text.toString())
        }
        button5.setOnClickListener{
            editText.setText(editText.text.toString() + button5.text.toString())
        }
        button6.setOnClickListener{
            editText.setText(editText.text.toString() + button6.text.toString())
        }
        button7.setOnClickListener{
            editText.setText(editText.text.toString() + button7.text.toString())
        }
        button8.setOnClickListener{
            editText.setText(editText.text.toString() + button8.text.toString())
        }
        button9.setOnClickListener{
            editText.setText(editText.text.toString() + button9.text.toString())
        }

        // 符号获取
        btnAdd.setOnClickListener{
            editText.setText(editText.text.toString() + " " + btnAdd.text.toString() + " ")
        }
        btnSub.setOnClickListener{
            editText.setText(editText.text.toString() + " "  + btnSub.text.toString() + " ")
        }
        btnMul.setOnClickListener{
            editText.setText(editText.text.toString() + " "  + btnMul.text.toString() + " ")
        }
        btnDiv.setOnClickListener{
            editText.setText(editText.text.toString() + " "  + btnDiv.text.toString() + " ")
        }
        btnd.setOnClickListener{
            editText.setText(editText.text.toString() +  btnd.text.toString())
        }

        // 等号
        equal.setOnClickListener{
            var str = editText.text.toString()
            println(str)
            if(str.isEmpty()){
                Toast.makeText(this@MainActivity,"请输入数值",Toast.LENGTH_LONG).show()
            }else{
                var ss = Utils2.calculateString(str).toString()
                println(ss)
                editText.setText(ss)
            }
        }

        // AC
        btnAC.setOnClickListener {
            editText.setText("")
        }


    }
}


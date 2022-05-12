package com.example.exam1application


import Stack2.Utils3
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        // 三角函数
        var btnSin:Button = findViewById(R.id.btnSin)
        var btnCos:Button = findViewById(R.id.btnCos)
        var btnTan:Button = findViewById(R.id.btnTan)

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

        // 三角函数计算
        btnSin.setOnClickListener {
            var str = editText.text.toString()
            if(str.isEmpty()){
                Toast.makeText(this@MainActivity,"请输入数值",Toast.LENGTH_LONG).show()
            }else{
                var str1 = str.toDouble()
                str1 = Math.sin(str1)
                editText.setText(str1.toString())
            }
        }

        btnCos.setOnClickListener {
            var str = editText.text.toString()
            if(str.isEmpty()){
                Toast.makeText(this@MainActivity,"请输入数值",Toast.LENGTH_LONG).show()
            }else{
                var str1 = str.toDouble()
                str1 = Math.cos(str1)
                editText.setText(str1.toString())
            }
        }

        btnTan.setOnClickListener {
            var str = editText.text.toString()
            if(str.isEmpty()){
                Toast.makeText(this@MainActivity,"请输入数值",Toast.LENGTH_LONG).show()
            }else{
                var str1 = str.toDouble()
                str1 = Math.tan(str1)
                editText.setText(str1.toString())
            }
        }

        // 等号
        equal.setOnClickListener{
            var str = editText.text.toString()
//            println(str)
            if(str.isEmpty()){
                Toast.makeText(this@MainActivity,"请输入数值",Toast.LENGTH_LONG).show()
            }
//            else if(Utils3.calculateString(str)==null){
//                Toast.makeText(this@MainActivity,"非法输入",Toast.LENGTH_LONG).show()
//                editText.setText("")
//            }
            else{
                try{
                    var ss = Utils3.calculateString(str)
                    if(ss.toString().equals("Infinity")){
                        Toast.makeText(this@MainActivity,"不能以0作为除数",Toast.LENGTH_LONG).show()
                        editText.setText("")
                    }
                    else{
                        editText.setText(ss.toString())
                    }
                }catch (e:Exception){
                    Toast.makeText(this@MainActivity,"非法输入",Toast.LENGTH_LONG).show()
                }

            }
        }

        // AC
        btnAC.setOnClickListener {
            editText.setText("")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.setting_item->{
                intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.baidu.com")
                startActivity(intent)
            }
            R.id.quit_item->finish()
        }
        return true
    }
}


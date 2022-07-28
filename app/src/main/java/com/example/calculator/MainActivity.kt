package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var firstnumber = 0F
    private var secondnumber = 0F
    private var switch = false
    private var text: String = ""
    private var operator = '.'
    private var dotflag = false
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener { append('1') }
        two.setOnClickListener { append('2') }
        three.setOnClickListener { append('3') }
        four.setOnClickListener { append('4') }
        five.setOnClickListener { append('5') }
        six.setOnClickListener { append('6') }
        seven.setOnClickListener { append('7') }
        eight.setOnClickListener { append('8') }
        nine.setOnClickListener { append('9') }
        zero.setOnClickListener { append('0') }
        dzero.setOnClickListener { append('0')
            append('0') }
        dot.setOnClickListener {
            if(!dotflag){
                append('.')
                dotflag = true
            }
        }

        back.setOnClickListener {
            val number= textView.text.toString()
            if(textView.text.toString() == "Error")
            {
                textView.text = "0"
            }
            else
            {
                textView.text = number.dropLast(1)
            }
            if(textView.text.toString() == ""){
                textView.text = "0"
            }
        }

        sum.setOnClickListener {
            operator()
            operator = '+'
            signView.text = operator.toString()
        }

        sub.setOnClickListener {
            operator()
            operator = '-'
            signView.text = operator.toString()
        }

        mul.setOnClickListener {
            operator()
            operator = '*'
            signView.text = operator.toString()
        }

        div.setOnClickListener {
            operator()
            operator = '/'
            signView.text = operator.toString()
        }

        cs.setOnClickListener {
            textView.text = "0"
            dotflag = false
            text = ""
        }

        ans.setOnClickListener {
            if(switch){
                text = textView.text.toString()
                secondnumber = text.toFloat()
                switch = false
                signView.text = ""
                when(operator)
                {
                    '+' -> textView.text = (firstnumber + secondnumber).toString()
                    '-' -> textView.text = (firstnumber - secondnumber).toString()
                    '*' -> textView.text = (firstnumber * secondnumber).toString()
                    '/' -> if(secondnumber == 0F){
                        textView.text = "Error"
                    }
                    else
                    {
                        textView.text = (firstnumber / secondnumber).toString()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun append(number : Char = '0'){
        if(textView.text == "Error" || textView.text == "0"){
            textView.text = ""
            textView.text = textView.text.toString() + number
        }
        else{
            textView.text = textView.text.toString() + number
        }

    }

    fun operator(){
        if(!switch){
            text = textView.text.toString()
            firstnumber = text.toFloat()
            switch = true
            dotflag = false
            textView.text = ""
        }
    }
}
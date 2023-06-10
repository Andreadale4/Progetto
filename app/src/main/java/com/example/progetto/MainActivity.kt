package com.example.progetto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    resultTextView = findViewById(R.id.resultTextView)

    val button0 = findViewById<Button>(R.id.button0)
    val button1 = findViewById<Button>(R.id.button1)
    val button2 = findViewById<Button>(R.id.button2)
    val button3 = findViewById<Button>(R.id.button3)
    val button4 = findViewById<Button>(R.id.button4)
    val button5 = findViewById<Button>(R.id.button5)
    val button6 = findViewById<Button>(R.id.button6)
    val button7 = findViewById<Button>(R.id.button7)
    val button8 = findViewById<Button>(R.id.button8)
    val button9 = findViewById<Button>(R.id.button9)
    val buttonDot = findViewById<Button>(R.id.buttonDot)
    val buttonEquals = findViewById<Button>(R.id.buttonEquals)
    val buttonPlus = findViewById<Button>(R.id.buttonPlus)
    val buttonMinus = findViewById<Button>(R.id.buttonMinus)
    val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
    val buttonDivide = findViewById<Button>(R.id.buttonDivide)
    val buttonOpenParenthesis = findViewById<Button>(R.id.buttonOpenParenthesis)
    val buttonCloseParenthesis = findViewById<Button>(R.id.buttonCloseParenthesis)
    val buttonClear = findViewById<Button>(R.id.buttonClear)

    val numberClickListener = View.OnClickListener {
        val number = (it as Button).text.toString()
        resultTextView.append(number)
    }


    button0.setOnClickListener(numberClickListener)
    button1.setOnClickListener(numberClickListener)
    button2.setOnClickListener(numberClickListener)
    button3.setOnClickListener(numberClickListener)
    button4.setOnClickListener(numberClickListener)
    button5.setOnClickListener(numberClickListener)
    button6.setOnClickListener(numberClickListener)
    button7.setOnClickListener(numberClickListener)
    button8.setOnClickListener(numberClickListener)
    button9.setOnClickListener(numberClickListener)

    buttonDot.setOnClickListener {
        if (!resultTextView.text.contains(".")) {
            resultTextView.append(".")
        }
    }
    buttonPlus.setOnClickListener {
        resultTextView.append("+")
    }
    buttonMinus.setOnClickListener {
        resultTextView.append("-")
    }
    buttonMultiply.setOnClickListener {
        resultTextView.append("*")
    }
    buttonDivide.setOnClickListener {
        resultTextView.append("/")
    }
    buttonOpenParenthesis.setOnClickListener {
        resultTextView.append("(")
    }
    buttonCloseParenthesis.setOnClickListener {
        resultTextView.append(")")
    }

    buttonClear.setOnClickListener {
        resultTextView.text = ""
    }

    buttonEquals.setOnClickListener {
        val expression = resultTextView.text.toString()
        try {
            val result = evaluateExpression(expression)
            resultTextView.text = result.toString()
        } catch (e: IllegalArgumentException) {
            resultTextView.text = "Error"
        }
    }
}

private fun evaluateExpression(expression: String): Double {
    val sanitizedExpression = expression.replace(" ", "")
    val exp = ExpressionBuilder(sanitizedExpression).build()
    return exp.evaluate()
}
}


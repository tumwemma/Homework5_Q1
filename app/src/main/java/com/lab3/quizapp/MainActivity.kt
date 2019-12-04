package com.lab3.quizapp


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



    fun onSubimit(view: View) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Quiz Result")
        var result :Int=0
        var message: String = ""
        val secondquestion: Boolean

        val Radio1 = Q1_option1.isChecked
        val checkBox1 = Q2_option1.isChecked
        val checkBox2 = Q2_option2.isChecked
        val checkBox3 = Q2_option3.isChecked
        val checkBox4 = Q2_option4.isChecked
        secondquestion = checkBox1 && checkBox2 && checkBox3 && !checkBox4
        val curentDate=Calendar.getInstance()
        var date:String=curentDate.get(Calendar.MONTH).toString()
        date+="-"
        date+=curentDate.get(Calendar.DAY_OF_MONTH).toString()
        date+="-"
        date+=curentDate.get(Calendar.YEAR).toString()

        var time:String=curentDate.get(Calendar.HOUR_OF_DAY).toString()
        time+=":"
        time+=curentDate.get(Calendar.MINUTE).toString()
        time+=":"
        time+=curentDate.get(Calendar.SECOND).toString()

        if (Radio1 && secondquestion)
            result = 100
        if (!Radio1 && !secondquestion)
            result = 0

        if (Radio1 && !secondquestion)
            result = 50

        if (!Radio1 && secondquestion)
            result = 50

        if (result > 0) {
            message = "Congratulations! \nYou submitted on current: $date  and $time: \nYou've achieved $result%"


            builder.setMessage(message)
                //builder.setIcon(R.drawable.information_icon)
                builder.setPositiveButton("Close") { dialogInterface, which ->
                    dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()


        } else {
            message = "Sorry!\nYou submitted on current: $date  and $time:\nYou've achieved $result%\nPlease Try again"
            builder.setMessage(message)
            //builder.setIcon(R.drawable.information_icon)
            builder.setPositiveButton("Close") { dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()

            Toast.makeText(this, "${message.trimMargin()} ", Toast.LENGTH_SHORT).show()
        }

        if (checkBox4) {
            Q2_option4.setTextColor(Color.RED)
            if (Q2_option1.isChecked)
            Q2_option1.setTextColor(Color.GREEN)
            else
                Q2_option1.setTextColor(Color.RED)
            if (Q2_option2.isChecked)
            Q2_option2.setTextColor(Color.GREEN)
            else
                Q2_option2.setTextColor(Color.RED)
            if (Q2_option3.isChecked)
            Q2_option3.setTextColor(Color.GREEN)
            else
               Q2_option3.setTextColor(Color.RED)
        }
        else{
        Q2_option4.setTextColor(Color.BLACK)
            //Q2_option4.setTextColor(Color.RED)
            if (Q2_option1.isChecked)
                Q2_option1.setTextColor(Color.GREEN)
            else
                Q2_option1.setTextColor(Color.RED)
            if (Q2_option2.isChecked)
                Q2_option2.setTextColor(Color.GREEN)
            else
                Q2_option2.setTextColor(Color.RED)
            if (Q2_option3.isChecked)
                Q2_option3.setTextColor(Color.GREEN)
            else
                Q2_option3.setTextColor(Color.RED)
        }

        if (Radio1) {
            Q1_option1.setTextColor(Color.GREEN)
            Q1_option2.setTextColor(Color.BLACK)
            Q1_option3.setTextColor(Color.BLACK)
        }
           else {
            Q1_option1.setTextColor(Color.BLACK)
            if (Q1_option2.isChecked) {
                Q1_option2.setTextColor(Color.RED)
                Q1_option3.setTextColor(Color.BLACK)
            }
            else {
                Q1_option3.setTextColor(Color.RED)
                Q1_option2.setTextColor(Color.BLACK)
            }
        }
    }
    fun onReset(view: View){
        Q1_option1.isChecked=false
        Q1_option2.isChecked=false
        Q1_option3.isChecked=false

        Q2_option1.isChecked=false
        Q2_option2.isChecked=false
        Q2_option3.isChecked=false
        Q2_option4.isChecked=false


        Q1_option1.setTextColor(Color.BLACK)
        Q1_option2.setTextColor(Color.BLACK)
        Q1_option3.setTextColor(Color.BLACK)

        Q2_option1.setTextColor(Color.BLACK)
        Q2_option2.setTextColor(Color.BLACK)
        Q2_option3.setTextColor(Color.BLACK)
        Q2_option4.setTextColor(Color.BLACK)
    }


    fun Curentdate(){


    }


   /* Curentdate()
    fun Curentdate(){

        curentDate=Calendar.getInstance()
        date=curentDate.get(Calendar.MONTH).toString()
        date+="-"
        date+=curentDate.get(Calendar.DAY_OF_MONTH).toString()
        date+="-"
        date+=curentDate.get(Calendar.YEAR).toString()

        var time:String=curentDate.get(Calendar.HOUR_OF_DAY).toString()
        time+=":"
        time+=curentDate.get(Calendar.MINUTE).toString()
        time+=":"
        time+=curentDate.get(Calendar.SECOND).toString()
    }

    lateinit var curentDate:Calendar
    lateinit var date:String
    lateinit var time:String*/


}

package com.mcandroid.higherorlower

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNumber()
        createListenerForButton()

    }

    fun generateRandomNumber(): Int{
        var random = Random()
        var min = 1
        var max = 10
        randomNum = random.nextInt(max + 1 - min) + min

        //toast(randomNum)
        return randomNum
    }

    fun assignRandomNumber(){
        randomNum = generateRandomNumber()
    }

    fun guessNumber(){
        var numberToGuess = randomNum
        var userGuess: Int = Integer.parseInt(numGuess.getText().toString())

        checkUserGuess(userGuess, numberToGuess)
    }

    fun checkUserGuess(userGuess:Int, numberToGuess:Int){
        if(userGuess > numberToGuess){
            lblFeedback.setText("Lower")
        } else if (userGuess < numberToGuess) {
            lblFeedback.setText("Higher")
        } else {
            lblFeedback.setText("Correct!")
        }
    }

    fun createListenerForButton() {
        btnGuess.setOnClickListener{
            guessNumber()
        }
    }
}

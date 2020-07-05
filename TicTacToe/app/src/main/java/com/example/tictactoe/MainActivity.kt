package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val player1 = mutableListOf<Int>()
    private val player2 = mutableListOf<Int>()
    private var buttonsPressed = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonElement = view as Button
        playGame(buttonElement)
    }

    private fun playGame(button: Button) {
        val buttonId = getButtonId(button)
        buttonsPressed += 1
        if (buttonsPressed % 2 !=0 ) {
            player1.add(buttonId)
            button.setBackgroundResource(R.color.blue)
            button.text = "X"
        } else {
            player2.add(buttonId)
            button.setBackgroundResource(R.color.darkGreen)
            button.text = "O"
        }
        button.isEnabled = false
        checkWinner()
        if(buttonsPressed >= 9) {
            Toast.makeText(this, "Let's restart the game!", Toast.LENGTH_LONG).show()
            restartTheGame()
        }
    }

    private fun checkWinner() {
        var winer = -1


        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }

        // diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }

        // diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }

        if (winer == 1) {
            Toast.makeText(this, "Player 1 won the game!", Toast.LENGTH_LONG).show()
            restartTheGame()

        } else if (winer == 2) {
            Toast.makeText(this, "Player 2 won the game!", Toast.LENGTH_LONG).show()
            restartTheGame()
        }
    }

    private fun restartTheGame() {
        for(cellId in 1 .. 9) {
            val buttonid = when(cellId) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                else -> button9
            }
            buttonid.text = ""
            buttonid.isEnabled = true
            buttonid.setBackgroundResource(R.color.buttonDefaultColor)
        }
        player1.clear()
        player2.clear()
        buttonsPressed = 0
    }

    private fun getButtonId(button: Button): Int {
        return when(button.id) {
            R.id.button1 -> 1
            R.id.button2 -> 2
            R.id.button3 -> 3
            R.id.button4 -> 4
            R.id.button5 -> 5
            R.id.button6 -> 6
            R.id.button7 -> 7
            R.id.button8 -> 8
            else -> 9
        }
    }
}
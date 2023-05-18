package com.example.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
// Know Button Select
    fun buSelect(view: View) {
        val buChoise = view as Button
        var CellID = 0
        when (buChoise.id) {
            R.id.bu1 -> CellID = 1
            R.id.bu2 -> CellID = 2
            R.id.bu3 -> CellID = 3
            R.id.bu4 -> CellID = 4
            R.id.bu5 -> CellID = 5
            R.id.bu6 -> CellID = 6
            R.id.bu7 -> CellID = 7
            R.id.bu8 -> CellID = 8
            R.id.bu9 -> CellID = 9
        }
        playGame(CellID,buChoise)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    fun playGame(CellId:Int , buChoise:Button){
        if (activePlayer==1){
            buChoise.text="X"
            buChoise.setBackgroundResource(R.color.blue)
            player1.add(CellId)
            activePlayer=2
            autoPlay()
        }else{
            buChoise.text="O"
            buChoise.setBackgroundResource(R.color.darkgreen)
            player2.add(CellId)
            activePlayer=1
        }
        buChoise.isEnabled=false
        checkWinner()

    }
    // Winnner In The Game
    fun checkWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player1.contains(9)) {
            winner = 2
        }
        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        // x 1
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        // x 2
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "player 1 win", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "player 2 win", Toast.LENGTH_LONG).show()
            }
        }
    }
    // play with phone
    fun autoPlay(){
        val emptyCell = ArrayList<Int>()
        for(cellID in 1..9){
            if (!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCell.add(cellID)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCell.size-0)+0
        val CellID = emptyCell[randIndex]
        var buSelect:Button?
        when(CellID){
            1->buSelect=bu1
            2->buSelect=bu2
            3->buSelect=bu3
            4->buSelect=bu4
            5->buSelect=bu5
            6->buSelect=bu6
            7->buSelect=bu7
            8->buSelect=bu8
            9->buSelect=bu9
            else->{
                buSelect=bu1
            }

        }
        playGame(CellID,buSelect)
    }
    }
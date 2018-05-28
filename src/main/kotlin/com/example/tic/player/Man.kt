package com.example.tic.player

import com.example.tic.Board
import com.example.tic.IncorrectInputException
import java.util.*

class Man(playerSign: Char) : Player {

    override val sign = playerSign
    override fun play(board: Board, players: ArrayList<Player>) {

        println("Manual player with sign : $sign playing")

        var (row, col) = readPosition(board)
        board.mark(row, col, sign)
        board.checkWin(sign)
    }

    private fun readPosition(board: Board): Pair<Int, Int> {
        var row = -1
        var col = -1
        while (row == -1 && col == -1) {
            println("Enter row,col and press enter")

            val inputString = readLine()!!
            try {

                val readValues = inputString.split(',')
                if (readValues.size > 2) {
                    throw IncorrectInputException("input values more then required")
                }
                row = readValues[0].trim().toInt()
                col = readValues[1].trim().toInt()
                if (row >= board.getSize() || col >= board.getSize() || row < 0 || col < 0) {
                    throw IncorrectInputException("not in limit")
                }
                if (board.getSignAt(row, col) != '-') {
                    throw IncorrectInputException("Already marked")
                }

            } catch (ex: Exception) {
                row = -1
                col = -1
                print("incorrect input: ${ex.message} . try again")
                continue
            }
        }
        return Pair(row, col)
    }


}
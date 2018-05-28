package com.example.tic

import com.example.tic.player.Computer
import com.example.tic.player.Man
import com.example.tic.player.Player


class TicTheGame {
    private lateinit var players: ArrayList<Player>
    private lateinit var board: Board

    fun initGame() {
        val configReader = com.example.tic.config.ConfigReader("../../../../tic.properties")

        players = ArrayList()

        players.add(Man(configReader.player1Sign))
        players.add(Man(configReader.player2Sign))
        players.add(Computer(configReader.computerSign))
        board = Board(configReader.boardSize)
    }

    fun startGame() {

        while (board.isMoveRemaining())
            players.forEach{it.play(board,players)}

    }


}

fun main(args: Array<String>) {

    val ticTheGame = TicTheGame()
    ticTheGame.initGame()
    ticTheGame.startGame()

}
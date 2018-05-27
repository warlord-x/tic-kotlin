package com.example.tic

import com.example.tic.player.ComputerPlayer
import com.example.tic.player.ManPlayer
import com.example.tic.player.Player


class TicTheGame {
    private lateinit var players: ArrayList<Player>
    private lateinit var board: Board

    fun initGame() {
        val configReader = com.example.tic.config.ConfigReader("../../../../tic.properties")

        players = ArrayList()

        players.add(ManPlayer(configReader.player1Sign))
        players.add(ManPlayer(configReader.player2Sign))
        players.add(ComputerPlayer(configReader.computerSign))
        board = Board(configReader.boardSize)
    }

    fun startGame() {
        while (board.isMoveRemaining()) {
            for (player in players) {
                player.play(board, players)
            }
        }
    }


}

fun main(args: Array<String>) {

    val ticTheGame = TicTheGame()
    ticTheGame.initGame()
    ticTheGame.startGame()

}
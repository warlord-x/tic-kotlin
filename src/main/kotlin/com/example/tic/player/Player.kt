package com.example.tic.player

import com.example.tic.Board

interface Player {
    val sign: Char
    fun play(board: Board, players: ArrayList<Player>)

}
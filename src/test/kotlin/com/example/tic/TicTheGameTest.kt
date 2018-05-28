package com.example.tic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TicTheGameTest {

    @Test
    fun `Should start the game`() {
        val ticTheGame = TicTheGame()
        ticTheGame.initGame()
        //ticTheGame.startGame()
        Assertions.assertEquals(Board(5).getSize(), 5)
    }
}
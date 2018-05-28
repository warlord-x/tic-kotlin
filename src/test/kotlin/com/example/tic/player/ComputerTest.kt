package com.example.tic.player
import com.example.tic.Board
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ComputerTest {

    @Test
    fun `Should play a move on the given board`() {
        val size = 5
        var board = Board(size)
        Computer('r').play(board, ArrayList())
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (board.getSignAt(i,j)=='r')
                    return
            }
        }
        Assertions.fail<String>("not marked on board")
    }
    @Test
    fun `Should play a move to stop win by other player`() {
        val size = 3
        var board = Board(size)
        board.mark(1, 0, 't')
        board.mark(1, 1, 't')

        Computer('r').play(board, arrayListOf(Man('t')))
        Assertions.assertEquals(board.getSignAt(1,2),'r')

    }
}
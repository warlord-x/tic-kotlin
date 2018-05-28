package com.example.tic.player

import com.example.tic.Board
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ManTest {

    @Test
    fun `Should Create a Man Player with expected sign`() {

        Assertions.assertEquals(Man('s').sign, 's')
    }
    @Test
     fun `Should play a valid move `(){
        val expected = "1,2\n"
        val fakeIS = ByteArrayInputStream(expected.toByteArray())
        System.setIn(fakeIS)

        var board = Board(3)
        Man('s').play(board,ArrayList())
        Assertions.assertEquals(board.getSignAt(1,2),'s')
    }
    @Test
     fun `Should print error on invalid move input and ask again`(){
        val expected = "1,21\n1,2\n"
        val fakeIS = ByteArrayInputStream(expected.toByteArray())
        System.setIn(fakeIS)
        var board = Board(3)
        val fakeOut = ByteArrayOutputStream()
        val fakePS = PrintStream(fakeOut)
        System.setOut(fakePS)
        Man('s').play(board,ArrayList())
        Assertions.assertTrue(fakeOut.toString().contains("incorrect input: not in limit"))
    }
    @Test
     fun `Should print error input that is already marked`(){
        val expected = "1,2\n1,0\n"
        val fakeIS = ByteArrayInputStream(expected.toByteArray())
        System.setIn(fakeIS)
        var board = Board(3)
        board.mark(1,2,'x')
        val fakeOut = ByteArrayOutputStream()
        val fakePS = PrintStream(fakeOut)
        System.setOut(fakePS)
        Man('s').play(board,ArrayList())
        Assertions.assertTrue(fakeOut.toString().contains("Already marked"))
    }

}
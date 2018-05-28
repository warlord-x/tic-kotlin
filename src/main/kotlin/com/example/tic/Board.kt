package com.example.tic

class Board(size: Int) {

    private val EMPTYMARK = '-'

    private var board: Array<CharArray>

    init {
        if (size < 3 || size > 10) throw IncorrectInputException("Incorrect board size specified")
        board = Array(size, { CharArray(size, { this.EMPTYMARK }) })
    }

    private fun printBoard() = board.forEach { println(it) }


    fun mark(row: Int, col: Int, sign: Char) {
        if (row >= getSize() || col >= getSize()) throw InvalidMoveException("Incorrect move")
        board[row][col] = sign
    }

    fun unMark(row: Int, col: Int) = mark(row,col, this.EMPTYMARK)

    fun getSize(): Int =  board.size

    fun getSignAt(row: Int, col: Int) = board[row][col]

    fun getRowWeight(computerSign: Char): Int {
        val k = board.size - 1
        for (row in 0..k) {
            var notMatched = true
            var i = 0

            while (i < k && notMatched) {
                if (board[row][i] != board[row][i + 1]) notMatched = false
                i++
            }

            if (notMatched) {

                if (board[row][i] == computerSign) return 1
                else if (board[row][i] != this.EMPTYMARK) return -1

            }

        }
        return 0
    }

    fun getColumnWeight(computerSign: Char): Int {
        val k = board.size - 1
        for (row in 0..k) {
            var notMatched = true
            var i = 0

            while (i < k && notMatched) {
                if (board[i][row] != board[i + 1][row]) notMatched = false
                i++
            }

            if (notMatched) {

                val tempSign = board[i][row]
                if (tempSign == computerSign) return 1
                else if (tempSign != this.EMPTYMARK) return -1

            }

        }
        return 0
    }



    fun getDiagonalWeight(computerSign: Char): Int {

        val result = 0
        var notMatched = true //TODO : Kotlin multile assignments
        val k = board.size - 1
        var i = 0

        while (i < k && notMatched) {
            if (board[i][i] != board[i + 1][i + 1]) notMatched = false
            i++
        }



        if (notMatched) {
            if (board[i][i] == computerSign) return 1
            else if (board[i][i] != this.EMPTYMARK) return -1

        }
        var j = k
        notMatched = true
        i = 0

        while (i < k && notMatched) {
            if (board[j][i] != board[j - 1][i + 1]) notMatched = false

            i++
            j--
        }

        if (notMatched) {
            if (board[j][i] == computerSign) return 1
            else if (board[j][i] != this.EMPTYMARK) return -1

        }

        return result

    }

    fun weightMove(computerSign: Char): Int {

        var weight = getRowWeight(computerSign)
        if (weight == 0) {
            weight = getColumnWeight(computerSign)
            if (weight == 0) {
                return getDiagonalWeight(computerSign)
            }
        }
        return weight
    }

    fun isMoveRemaining() = board.any ({ it.contains(this.EMPTYMARK) })

    fun checkWin(sign: Char) {
        printBoard()
        when (weightMove(sign)) {
            1 -> {
                println("Game over. I win!!")
                System.exit(1)
            }
            -1 -> {
                println("Game over. Player with Sign {$sign} wins!!")
                System.exit(1)
            }
            else -> {
                if (!isMoveRemaining()) {
                    println("no moves remaining ..exiting")
                    System.exit(1)
                }
            }
        }

    }


}


data class InvalidMoveException(override val message: String) : Exception(message)
data class IncorrectInputException(override val message: String) : Exception(message)

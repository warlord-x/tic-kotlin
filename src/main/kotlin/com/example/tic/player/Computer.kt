package com.example.tic.player

import com.example.tic.Board

class Computer(computerSign: Char) : Player {

    override val sign = computerSign

    override fun play(board: Board, players: ArrayList<Player>) {
        println("Computer playing with sign : $sign ")

        var rowSelected = -1
        var columnSelected = -1

        var highVal = Int.MIN_VALUE

        for (row in 0 until board.getSize()) {
            for (column in 0 until board.getSize()) {
                if (board.getSignAt(row, column) == '-') {
                    board.mark(row, column, sign)
                    val value = finder(board, false, 2, players)
                    board.unMark(row, column)
                    if (value > highVal) {
                        highVal = value
                        rowSelected = row
                        columnSelected = column
                    }
                }
            }
        }
        board.mark(rowSelected, columnSelected, sign)
        board.checkWin(sign)
    }


    private fun finder(board: Board, isComputer: Boolean, recursionLevel: Int, players: ArrayList<Player>): Int {

        val score = board.weightMove(sign)

        if (score == 1 || score == -1 || recursionLevel == 0) return score

        if (!board.isMoveRemaining()) return 0

        when (isComputer) {
            true -> {
                var best = -1000

                for (row in 0 until board.getSize()) {
                    for (column in 0 until board.getSize()) {
                        if (board.getSignAt(row, column) == '-') {
                            board.mark(row, column, sign)
                            best = Math.max(finder(board, !isComputer, recursionLevel - 1, players), best)
                            board.unMark(row, column)
                        }
                    }
                }
                return best
            }
            else -> {
                var best = 1000
                for (row in 0 until board.getSize()) {
                    for (column in 0 until board.getSize()) {
                        if (board.getSignAt(row, column) == '-') {
                            for (player in players) {
                                if (player.sign != sign) {
                                    board.mark(row, column, player.sign)
                                    best = Math.min(finder(board, !isComputer, recursionLevel - 1, players), best)
                                    board.mark(row, column, '-')
                                }
                            }


                        }
                    }
                }
                return best
            }
        }

    }

}
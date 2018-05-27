package com.example.tic.config

import java.io.FileNotFoundException
import java.util.*

class ConfigReader(configFilePath: String) {
    val player1Sign: Char
    val player2Sign: Char
    val computerSign: Char
    val boardSize: Int


    private val properties: Properties = Properties()

    init {

        val resourceAsStream = javaClass.getResourceAsStream(configFilePath)
                ?: throw FileNotFoundException("config file not found")

        properties.load(resourceAsStream)
        player1Sign = properties.getProperty("player.1.char")[0]
        player2Sign = properties.getProperty("player.2.char")[0]
        computerSign = properties.getProperty("computer.char")[0]
        boardSize = properties.getProperty("board.size").toInt() //TODO : TEST CASE
    }


}







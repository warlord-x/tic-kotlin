package com.example.tic.config

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.FileNotFoundException


class ConfigReaderTest {

    @Test
    fun `Should give correct property values for given file`() {

        val configReader = ConfigReader("../../../../tic.properties")
        Assertions.assertEquals('i', configReader.player1Sign)
        Assertions.assertEquals('j', configReader.player2Sign)
        Assertions.assertEquals('*', configReader.computerSign)

    }

    @Test()

    fun `Should report error for incorrect filepath`() {
        Assertions.assertThrows(FileNotFoundException::class.java) {
            ConfigReader("incorrectFilePath")
        }
    }

}
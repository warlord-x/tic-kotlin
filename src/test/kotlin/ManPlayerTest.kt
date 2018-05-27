import com.example.tic.player.ManPlayer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ManPlayerTest {

    @Test
    fun `Should Create a Man Player with expected sign`() {

        Assertions.assertEquals(ManPlayer('s').sign, 's')
    }
    /*@Test
    fun `Should play a valid move `(){
        ManPlayer('s').play(1,2)

        Assertions.assertEquals(ManPlayer('s').sign,'s')
    }*/
}
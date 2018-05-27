import com.example.tic.Board
import com.example.tic.IncorrectInputException
import com.example.tic.InvalidMoveException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun `Should Create a board of given size`() {
        Assertions.assertEquals(Board(5).getSize(), 5)
    }

    @Test
    fun `Should mark given sign on board at given place`() {
        val board = Board(5)
        board.mark(1, 2, 't')
        Assertions.assertEquals(board.getSignAt(1, 2), 't')

    }

    @Test
    fun `Should throw exception if position is incorrect`() {
        val board = Board(5)

        Assertions.assertThrows(InvalidMoveException::class.java) {
            board.mark(5, 3, 'x')
        }

    }

    @Test
    fun `Should throw exception if board size is not between 1-10`() {

        Assertions.assertThrows(IncorrectInputException::class.java) {
            Board(-1)
        }
        Assertions.assertThrows(IncorrectInputException::class.java) {
            Board(11)
        }

    }

    @Test
    fun `Should return row win for computer`() {
        val board = Board(5)
        board.mark(1, 0, 't')
        board.mark(1, 1, 't')
        board.mark(1, 2, 't')
        board.mark(1, 3, 't')
        board.mark(1, 4, 't')
        Assertions.assertEquals(1, board.getRowWeight('t'))
        val board2 = Board(5)
        board2.mark(2, 0, 't')
        board2.mark(2, 1, 't')
        board2.mark(2, 2, 't')
        board2.mark(2, 3, 't')
        board2.mark(2, 4, 't')
        Assertions.assertEquals(1, board2.getRowWeight('t'))

    }

    @Test
    fun `Should return row win for opponent`() {
        val board = Board(5)
        board.mark(1, 0, 't')
        board.mark(1, 1, 't')
        board.mark(1, 2, 't')
        board.mark(1, 3, 't')
        board.mark(1, 4, 't')
        Assertions.assertEquals(-1, board.getRowWeight('j'))
        val board2 = Board(5)
        board2.mark(2, 0, 't')
        board2.mark(2, 1, 't')
        board2.mark(2, 2, 't')
        board2.mark(2, 3, 't')
        board2.mark(2, 4, 't')
        Assertions.assertEquals(-1, board2.getRowWeight('j'))

    }

    @Test
    fun `Should return no win`() {
        val board = Board(5)
        board.mark(1, 0, 't')
        board.mark(1, 1, 't')
        board.mark(1, 2, 'j')
        board.mark(1, 3, 't')
        board.mark(1, 4, 't')
        Assertions.assertEquals(0, board.getRowWeight('j'))
        val board2 = Board(5)
        board2.mark(2, 0, 't')
        board2.mark(2, 1, 't')
        board2.mark(2, 2, 't')
        board2.mark(2, 3, 'i')
        board2.mark(2, 4, 't')
        Assertions.assertEquals(0, board2.getRowWeight('j'))

    }

    @Test
    fun `Should return column win for computer`() {
        val board = Board(5)
        board.mark(0, 1, 't')
        board.mark(1, 1, 't')
        board.mark(2, 1, 't')
        board.mark(3, 1, 't')
        board.mark(4, 1, 't')
        Assertions.assertEquals(1, board.getColumnWeight('t'))
        val board2 = Board(5)
        board2.mark(0, 2, 't')
        board2.mark(1, 2, 't')
        board2.mark(2, 2, 't')
        board2.mark(3, 2, 't')
        board2.mark(4, 2, 't')
        Assertions.assertEquals(1, board2.getColumnWeight('t'))

    }

    @Test
    fun `Should return diagonal win for computer`() {
        val board = Board(5)
        board.mark(0, 0, 't')
        board.mark(1, 1, 't')
        board.mark(2, 2, 't')
        board.mark(3, 3, 't')
        board.mark(4, 4, 't')
        Assertions.assertEquals(1, board.getDiagonalWeight('t'))
        val board2 = Board(5)
        board2.mark(0, 4, 't')
        board2.mark(1, 3, 't')
        board2.mark(2, 2, 't')
        board2.mark(3, 1, 't')
        board2.mark(4, 0, 't')
        Assertions.assertEquals(1, board2.getDiagonalWeight('t'))

    }

    @Test
    fun `Should return diagonal win for opponent`() {
        val board = Board(5)
        board.mark(0, 0, 't')
        board.mark(1, 1, 't')
        board.mark(2, 2, 't')
        board.mark(3, 3, 't')
        board.mark(4, 4, 't')
        Assertions.assertEquals(-1, board.getDiagonalWeight('y'))
        val board2 = Board(5)
        board2.mark(0, 4, 't')
        board2.mark(1, 3, 't')
        board2.mark(2, 2, 't')
        board2.mark(3, 1, 't')
        board2.mark(4, 0, 't')
        Assertions.assertEquals(-1, board2.getDiagonalWeight('u'))

    }


}
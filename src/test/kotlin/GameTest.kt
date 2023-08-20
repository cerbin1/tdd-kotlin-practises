import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun shouldThrowForNegativeOnePoint() {
//        given
        val game = Game()

//        when & then
        assertThrows<IllegalArgumentException> {
            game.roll(-1)
        }
    }

    @Test
    fun shouldThrowForNegativePoints() {
//        given
        val game = Game()

//        when & then
        assertThrows<IllegalArgumentException> {
            game.roll(-10)
        }
    }

    @Test
    fun shouldGetOnePointsInSingleGameWithOnePoint() {
//        given
        val game = Game()

//        when
        game.roll(1)

//        then
        assertEquals(1, game.points)
    }


    @Test
    fun shouldGetPointsCalculatedFromTwoRolls() {
//        given
        val game = Game()

//        when
        game.roll(1)
        game.roll(1)

//        then
        assertEquals(2, game.points)

    }
}

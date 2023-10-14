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
    fun shouldGetNoPointFromOneRollWhenZeroIsRolled() {
//        given
        val game = Game()

//        when
        game.roll(0)

//        then
        assertEquals(0, game.points)
    }

    @Test
    fun shouldGetOnePointFromOneRoll() {
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

    @Test
    fun shouldGetDoublePointsWhenSpareIsHitInPreviousRound() {
//        given
        val game = Game()

//        when
        game.roll(5)
        game.roll(5)
        game.roll(3)

//        then
        assertEquals(16, game.points)
    }

    @Test
    fun shouldGetDoublePointsInNextTwoRollsWhenStrikeIsHitInPreviousRound() {
//        given
        val game = Game()

//        when
        game.roll(10)
        game.roll(3)
        game.roll(4)

//        then
        assertEquals(24, game.points)
    }

}

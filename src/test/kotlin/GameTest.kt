import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class GameTest {

    @Test
    fun shouldThrowForNegativeOnePoint() {
//        given
        val game = Game();

//        when
        assertThrows<IllegalArgumentException> {
            game.roll(-1);
        }
    }

    @Test
    fun shouldThrowForNegativePoints() {
//        given
        val game = Game();

//        when
        assertThrows<IllegalArgumentException> {
            game.roll(-10);
        }
    }

}
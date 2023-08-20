class Game {
    var points: Int = 0

    fun roll(rollPoints: Int) {
        if (rollPoints < 0) {
            throw IllegalArgumentException()
        }
        points += rollPoints
    }
}

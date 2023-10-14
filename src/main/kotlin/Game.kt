class Game {
    var points: Int = 0
    var previousTurnPoints: Int = 0
    var turnPoints: Int = 0
    var rollNumber: Int = 1
    var bonus: Int = 0

    fun roll(rollPoints: Int) {
        if (rollPoints < 0) {
            throw IllegalArgumentException()
        }
        points += rollPoints
        if (bonus > 0) {
            points += rollPoints
            bonus--
        }
        turnPoints = rollPoints

        if (isSecondRoll()) {
            if (isSpare()) {
                bonus++
            }
            turnPoints = 0
            previousTurnPoints = 0
        }

        previousTurnPoints = turnPoints
        rollNumber++
    }

    private fun isSpare() = turnPoints + previousTurnPoints == 10

    private fun isSecondRoll() = rollNumber % 2 == 0
}

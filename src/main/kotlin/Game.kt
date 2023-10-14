class Game {
    var points: Int = 0
    var previousTurnPoints: Int = 0
//    var turnPoints: Int = 0
    var rollNumber: Int = 1
    var bonusPointsMultiplierCount: Int = 0

    fun roll(rollPoints: Int) {
        if (rollPoints < 0) {
            throw IllegalArgumentException()
        }
        points += rollPoints
        if (bonusPointsMultiplierCount > 0) {
            points += rollPoints
            bonusPointsMultiplierCount--
        }

        if (isStrike(rollPoints)) {
            bonusPointsMultiplierCount += 2
            previousTurnPoints = 0
        }

        if (isSecondRoll()) {
            if (isSpare(rollPoints)) {
                bonusPointsMultiplierCount++
            }
            previousTurnPoints = 0
        }

        previousTurnPoints = rollPoints
        rollNumber++
    }

    private fun isSpare(rollPoints: Int) = rollPoints + previousTurnPoints == 10

    private fun isStrike(rollPoints: Int) = isFirstRoll() && rollPoints == 10

    private fun isFirstRoll() = rollNumber % 2 == 1

    private fun isSecondRoll() = !isFirstRoll()
}

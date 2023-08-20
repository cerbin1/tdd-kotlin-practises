class Game {
    fun roll(points: Int) {
        if (points < 0) {
            throw IllegalArgumentException()
        }
    }

    fun getPoints(): Int {
        return 1;
    }
}
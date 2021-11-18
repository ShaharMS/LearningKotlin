import kotlin.random.Random
import kotlin.Int;

class Game {

    var num:Int = 0
    var iterations:Int = 0;
    fun generateNumber():Game {
        num = Random.nextInt(0, 1000000); return this
    }

    fun start() {
        val number = readLine()!!.toInt()

        if (number > num) {
            println("Lower!")
            iterations++
            start()
        }
        else if (number < num) {
            println("Higher!")
            iterations++
            start()
        }
        else if (number == num) {
            println("Nice One! You Hit The Secret Number In $iterations tries! Press ENTER To Try Again")
            val sus = readLine()
            main()
        }
    }
}

fun main() {
    println("The Ultimate Game - Higher Or Lower!")
    Game().generateNumber().start()
}
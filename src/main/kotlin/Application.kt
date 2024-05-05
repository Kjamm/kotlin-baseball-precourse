fun main() {
    val game = Application()
    game.play()
}

class Application {
    private var computerNumbers = ComputerNumberGenerator.generate()

    fun play() {

        do {
            val userInput = Input()
            val result = check(userInput, computerNumbers)
            println(result)
        } while (!result.isCorrect())

        println("축하합니다! 숫자를 모두 맞히셨습니다!")

        if (playAgain()) {
            computerNumbers = ComputerNumberGenerator.generate() // 새로운 랜덤 숫자 생성
            play() // 게임 다시 시작
        } else {
            println("게임을 종료합니다.")
        }
    }

    private fun playAgain(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val choice = readLine()?.toIntOrNull() ?: 2
        return choice == 1
    }
}

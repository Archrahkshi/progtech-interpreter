fun main() {
    val interpreter = MyInterpreter()
    val numbers = listOf("0", "1234567", "419", "007", "18010", "", "asdf",
        "-9876543", "-0", "0x14D", "14.3", "70 000", "6e3", "75_800", "--3", "+60")
    numbers.forEach { println("$it -> ${interpreter.interpret(it)}") }
}

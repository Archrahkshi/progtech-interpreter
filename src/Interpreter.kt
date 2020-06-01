interface Interpreter {
    fun one(): String
    fun two(): String
    fun three(): String
    fun four(): String
    fun five(): String
    fun six(): String
    fun seven(): String
    fun eight(): String
    fun nine(): String
    fun zero(): String

    fun interpret(number: Pair<String, String>) = Pair(
        number.first.drop(1),
        number.second + when (number.first.first()) {
            '1' -> one()
            '2' -> two()
            '3' -> three()
            '4' -> four()
            '5' -> five()
            '6' -> six()
            '7' -> seven()
            '8' -> eight()
            '9' -> nine()
            '0' -> zero()
            else -> ""
        }
    )
}

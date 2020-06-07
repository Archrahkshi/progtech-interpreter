/**
 * Интерфейс, описывающий функции для интерпретации каждой цифры
 * и определяющий, какой цифре какая функция соответствует.
 */
interface Position {
    /**
     * Интерпретация цифр.
     */
    fun zero(): String
    fun one(): String
    fun two(): String
    fun three(): String
    fun four(): String
    fun five(): String
    fun six(): String
    fun seven(): String
    fun eight(): String
    fun nine(): String

    /**
     * Интерпретация одного разряда числа.
     * @param number пара, содержащая представление числа в цифровом и текстовом виде.
     * @return та же пара с учётом интерпретации данного разряда.
     */
    fun interpret(number: Pair<String, String>) = Pair(
        number.first.drop(1),
        number.second + when (number.first.first()) {
            '0' -> zero()
            '1' -> one()
            '2' -> two()
            '3' -> three()
            '4' -> four()
            '5' -> five()
            '6' -> six()
            '7' -> seven()
            '8' -> eight()
            '9' -> nine()
            else -> ""
        }
    )
}

import java.lang.NumberFormatException

class MyInterpreter {
    private val millions = One()
    private val hundredsOfThousands = Hundred()
    private val tensOfThousands = Ten()
    private val thousands = Thousand()
    private val tenToNineteenThousand = TenToNineteen()
    private val hundreds = Hundred()
    private val tens = Ten()
    private val ones = One()
    private val tenToNineteen = TenToNineteen()

    fun interpret(input: String): String {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            return "Некорректный ввод!"
        }
        if (input.isEmpty()) return "Некорректный ввод!"

        var numberForm = input
        var stringForm = ""

        if (numberForm.startsWith('-')) {
            stringForm += "Минус "
            numberForm = numberForm.drop(1)
        }
        if (numberForm == "0") return "Ноль"
        if (stringForm.length > 7) return "Введите число поменьше!"

        val hasMillions = numberForm.length > 6
        val hasThousands = numberForm.length > 3

        numberForm = "${"0".repeat(7 - numberForm.length)}$numberForm"

        var number = Pair(numberForm, stringForm)

        val wordMillions = if (hasMillions) when (number.first.first()) {
            '1' -> "миллион "
            '2', '3', '4' -> "миллиона "
            else -> "миллионов "
        } else ""
        number = millions.interpret(number)
        number = Pair(number.first, number.second + wordMillions)
        number = hundredsOfThousands.interpret(number)
        val wordThousands: String
        if (number.first.first() == '1') {
            number = Pair(number.first.drop(1), number.second)
            number = tenToNineteenThousand.interpret(number)
            wordThousands = if (hasThousands) when (number.first.first()) {
                '1' -> "тысяча "
                '2', '3', '4' -> "тысячи "
                else -> "тысяч "
            } else ""
        } else {
            number = tensOfThousands.interpret(number)
            wordThousands = if (hasThousands) when (number.first.first()) {
                '1' -> "тысяча "
                '2', '3', '4' -> "тысячи "
                else -> "тысяч "
            } else ""
            number = thousands.interpret(number)
        }
        number = Pair(number.first, number.second + wordThousands)
        number = hundreds.interpret(number)
        if (number.first.first() == '1') {
            number = Pair(number.first.drop(1), number.second)
            number = tenToNineteen.interpret(number)
        } else {
            number = tens.interpret(number)
            number = ones.interpret(number)
        }

        return number.second.trimEnd().capitalize()
    }
}

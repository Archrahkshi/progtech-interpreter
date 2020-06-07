import java.lang.NumberFormatException

/**
 * Класс, отвечающий за интерпретацию конкретного числа от -9_999_999 до 9_999_999.
 */
class Interpreter {
    // Каждая из переменных соответствует одному из разрядов числа,
    // включая особые случаи: от 10 до 19 и от 10 тысяч до 19 тысяч.
    // Некоторые являются объектами одного и того же класса,
    // так как интерпретации разных разрядов могут совпадать.
    private val millions = One()
    private val hundredsOfThousands = Hundred()
    private val tensOfThousands = Ten()
    private val thousands = Thousand()
    private val tenToNineteenThousand = TenToNineteen()
    private val hundreds = Hundred()
    private val tens = Ten()
    private val ones = One()
    private val tenToNineteen = TenToNineteen()

    /**
     * Постановка слова "миллион" в соответствующий падеж.
     * @param hasMillions индикатор наличия разряда миллионов в числе.
     * @param number пара, содержащая представление числа в цифровом и текстовом виде.
     * @return та же пара с учётом слова "миллион".
     */
    private fun setWordMillions(
        hasMillions: Boolean,
        number: Pair<String, String>
    ) = if (hasMillions) when (number.first.first()) {
        '1' -> "миллион "
        '2', '3', '4' -> "миллиона "
        else -> "миллионов "
    } else ""

    /**
     * Постановка слова "тысяча" в соответствующий падеж.
     * @param hasThousands индикатор наличия разряда тысяч в числе.
     * @param number пара, содержащая представление числа в цифровом и текстовом виде.
     * @return та же пара с учётом слова "тысяча".
     */
    private fun setWordThousands(
        hasThousands: Boolean,
        number: Pair<String, String>
    ) = if (hasThousands) when (number.first.first()) {
        '1' -> "тысяча "
        '2', '3', '4' -> "тысячи "
        else -> "тысяч "
    } else ""

    /**
     * Непосредственная интерпретация данного числа.
     * @param input входное число в цифровом виде.
     * @return то же число в текстовом виде.
     */
    fun interpret(input: String): String {
        // Проверки ввода (число ли это вообще)
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            return "Некорректный ввод!"
        }
        if (input.isEmpty()) return "Некорректный ввод!"

        // Переменные для хранения цифрового и текстового вида числа
        // в целях дальнейшей модификации
        var numberForm = input
        var stringForm = ""

        // Проверки ввода на знак и длину
        if (numberForm.startsWith('-')) {
            stringForm += "Минус "
            numberForm = numberForm.drop(1)
        }
        if (numberForm == "0") return "Ноль"
        if (stringForm.length > 7) return "Введите число поменьше!"

        // Индикаторы наличия разрядов миллионов и тысяч
        val hasMillions = numberForm.length > 6
        val hasThousands = numberForm.length > 3

        // Заполнение отсутствующих разрядов нулями
        numberForm = "${"0".repeat(7 - numberForm.length)}$numberForm"

        // Создание пары (цифры, текст) в целях дальнейшей модификации
        var number = Pair(numberForm, stringForm)

        // Собственно интерпретация
        val wordMillions = setWordMillions(hasMillions, number)
        number = millions.interpret(number)
        number = Pair(number.first, number.second + wordMillions)
        number = hundredsOfThousands.interpret(number)
        val wordThousands: String
        if (number.first.first() == '1') {
            number = Pair(number.first.drop(1), number.second)
            number = tenToNineteenThousand.interpret(number)
            wordThousands = setWordThousands(hasThousands, number)
        } else {
            number = tensOfThousands.interpret(number)
            wordThousands = setWordThousands(hasThousands, number)
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

        // Удаляем лишний пробел в конце и делаем первую букву заглавной
        return number.second.trimEnd().capitalize()
    }
}

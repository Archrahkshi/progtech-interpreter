/**
 * Классы, реализующие разряды.
 */

class Thousand : Interpreter {
    override fun zero() = ""
    override fun one() = "одна "
    override fun two() = "две "
    override fun three() = "три "
    override fun four() = "четыре "
    override fun five() = "пять "
    override fun six() = "шесть "
    override fun seven() = "семь "
    override fun eight() = "восемь "
    override fun nine() = "девять "
}

class Hundred : Interpreter {
    override fun zero() = ""
    override fun one() = "сто "
    override fun two() = "двести "
    override fun three() = "триста "
    override fun four() = "четыреста "
    override fun five() = "пятьсот "
    override fun six() = "шестьсот "
    override fun seven() = "семьсот "
    override fun eight() = "восемьсот "
    override fun nine() = "девятьсот "
}

class Ten : Interpreter {
    override fun zero() = ""
    override fun one() = "десять "
    override fun two() = "двадцать "
    override fun three() = "тридцать "
    override fun four() = "сорок "
    override fun five() = "пятьдесят "
    override fun six() = "шестьдесят "
    override fun seven() = "семьдесят "
    override fun eight() = "восемьдесят "
    override fun nine() = "девяносто "
}

class One : Interpreter {
    override fun zero() = ""
    override fun one() = "один "
    override fun two() = "два "
    override fun three() = "три "
    override fun four() = "четыре "
    override fun five() = "пять "
    override fun six() = "шесть "
    override fun seven() = "семь "
    override fun eight() = "восемь "
    override fun nine() = "девять "
}

class TenToNineteen : Interpreter {
    override fun zero() = "десять "
    override fun one() = "одиннадцать "
    override fun two() = "двенадцать "
    override fun three() = "тринадцать "
    override fun four() = "четырнадцать "
    override fun five() = "пятнадцать "
    override fun six() = "шестнадцать "
    override fun seven() = "семнадцать "
    override fun eight() = "восемнадцать "
    override fun nine() = "девятнадцать "
}
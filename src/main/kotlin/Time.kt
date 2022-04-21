val valueOfSeconds = (0 until 172300).random()
const val SECOND = 60
const val BLANK = "был(а) в сети"
val time = time()
val dummy = agoToText()

fun main() {
    println("Сгенерировано $valueOfSeconds секунд")
    print(BLANK + dummy)
}

fun time(): Int? {
    return when (valueOfSeconds) {
        in 60..3599 -> valueOfSeconds / SECOND
        in 3600..86399 -> valueOfSeconds / SECOND / SECOND
        else -> null
    }
}

fun agoToText(): String {
    return when {
        valueOfSeconds < SECOND -> " только что"
        valueOfSeconds < SECOND * SECOND && (valueOfSeconds / SECOND) % 10 == 1 && valueOfSeconds / SECOND != 11 -> " $time минуту назад"
        valueOfSeconds < SECOND * SECOND && (valueOfSeconds / SECOND) % 10 in 2..4 && valueOfSeconds / SECOND !in 12..14 -> " $time минуты назад"
        valueOfSeconds < SECOND * SECOND && (valueOfSeconds / SECOND) % 10 in 0..9 -> " $time минут назад"
        valueOfSeconds < SECOND * SECOND * 24 && (valueOfSeconds / SECOND / SECOND) % 10 == 1 && (valueOfSeconds / SECOND / SECOND) != 11 -> " $time час назад"
        valueOfSeconds < SECOND * SECOND * 24 && (valueOfSeconds / SECOND / SECOND) in 5..20 -> " $time часов назад "
        valueOfSeconds < SECOND * SECOND * 24 && (valueOfSeconds / SECOND / SECOND) % 10 in 2..4 -> " $time часа назад"
        valueOfSeconds < SECOND * SECOND * 24 * 2 && valueOfSeconds >= SECOND * SECOND * 24 -> " вчера "
        else -> " давно "
    }
}
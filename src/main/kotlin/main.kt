package ru.netology

fun hoursToText(hours: Int): String {
    return if (hours in 11..20) {
        "Был(а) $hours  часов назад"
    } else {
        when (hours%10) {
            1 -> "Был(а) $hours  час назад"
            in 2..4 -> "Был(а) $hours  часа назад"
            else -> "Был(а) $hours  часов назад"
        }
    }
}

fun minsToText(mins: Int): String {
    return if (mins in 11..14) {
        "Был(а) $mins  минут назад" 
    } else {
        when (mins%10) {
            1 -> "Был(а) $mins минуту"
            in 2..4 -> "Был(а) $mins минуты"
            else -> "Был(а) $mins минут"
        }
    }
}

fun agoToText(sec: Int): String {
//    val result = "был(а) "
    val hours: Int = sec / 3600
    val mins: Int = (sec - hours*3600) / 60
    val dayInSecs: Int = 24*60*60
    return when (sec) {
        in 0..60 -> "Был(а) только что"
        in 61..60*60 -> "${minsToText(mins)} назад"
        in 60*60+1.. dayInSecs -> "${hoursToText(hours)} назад"
        in dayInSecs+1..2*dayInSecs ->  "Был(а) сегодня"
        in 2*dayInSecs+1..3*dayInSecs -> "Был(а)вчера"
        else -> "Был(а)давно"
    }
}

fun main() {
    println(3673/60)
    println(agoToText(3673))
}
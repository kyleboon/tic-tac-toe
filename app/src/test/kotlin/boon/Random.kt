package boon

import kotlin.random.Random

const val MIN = 1000
const val MAX = 9999
const val LENGTH = 8
const val DEFAULT_PERCENTAGE_NULL = 25
const val MILLIS_PER_DAY: Long = 1000 * 60 * 60 * 24

// characters used by the randomString functions
private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

val random = Random(Runtime.getRuntime().freeMemory() + System.nanoTime())

fun randomInt(range: IntRange) = randomInt(range.first, range.last)
fun randomInt(min: Int = MIN, max: Int = 9999) = random.nextInt(min, max)
fun randomInt(digits: Int) = when {
    digits == 1 -> randomInt(min = 0, max = 9)
    digits > 0 -> randomInt(
        min = ("1" + "0".repeat(digits - 1)).toInt(),
        max = ("9".repeat(digits)).toInt()
    )
    else -> throw IllegalArgumentException("digits must be greater than 0")
}
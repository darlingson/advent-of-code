package twentyTwentyFive.dayOne

import java.io.File

fun main() {
    val filePath = "src/twentyTwentyFive/dayOne/data.txt"

    try {
        val content = File(filePath).readText()
        val dials = content.lines().filter { it.isNotBlank() }

        var position = 50
        var landedAtZero = 0

        dials.forEach { dial ->
            val direction = dial[0]
            val steps = dial.substring(1).toInt()

            repeat(steps) {
                if (direction == 'L') {
                    position--
                    if (position < 0) position = 99
                } else {
                    position++
                    if (position > 99) position = 0
                }

                if (position == 0) {
                    landedAtZero++
                }
            }
        }

        println("Final position: $position")
        println("Total zero clicks: $landedAtZero")

    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
    }
}

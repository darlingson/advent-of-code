package twentyTwentyFive.dayOne

import java.io.File

fun main() {
    val filePath = "src/twentyTwentyFive/dayOne/data.txt"
    //loop through the dials
    //if dial starts with L, we subtract
    //if dial starts with R, we add
    //if we hit 0 with subtract or add we add to landed at zero
    //max is 99, min is 0
    //if we hit 99 after add, we circle back to 0 and continue adding
    // if we hit 0 after subtract, we circle back to 99 and continue subtracting

    try {
        val content = File(filePath).readText()
        val dials = content.lines().filter { it.isNotBlank() }

        var position = 50
        var landedAtZero = 0

        dials.forEach { dial ->
            val direction = dial[0]
            val steps = dial.substring(1).toInt()

            val newPosition = if (direction == 'L') {
                (position - steps).mod(100)
            } else {
                (position + steps) % 100
            }

            if (newPosition == 0) landedAtZero++

            position = newPosition
        }

        println("Final position: $position")
        println("Times landed on 0: $landedAtZero")

    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
    }
}

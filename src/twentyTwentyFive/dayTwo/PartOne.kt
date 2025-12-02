package twentyTwentyFive.dayTwo

import java.io.File

fun main() {
    val filePath = "src/twentyTwentyFive/dayTwo/data.txt"

    try {
        val content = File(filePath).readText()
        val ranges = content.split(",").filter { it.isNotBlank() }

        var invalidIdsSum = 0L

        ranges.forEach { range ->
            val parts = range.split("-")
            val start = parts[0].toLong()
            val end = parts[1].toLong()

            for (i in start..end) {
                //base logic
                //turn number to string
                // break it in the middle
                // turn the two ends into ints
                // compare the two, if they are the same the id is invalid and add it to the sum

                val s = i.toString()

                if (s.length % 2 != 0) continue

                val mid = s.length / 2
                val first = s.substring(0, mid)
                val second = s.substring(mid)

                // second part must not start with zero:
                if (second.startsWith("0")) continue

                if (first == second) {
                    invalidIdsSum += i
                }
            }
        }

        println("Sum of invalid IDs = $invalidIdsSum")

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

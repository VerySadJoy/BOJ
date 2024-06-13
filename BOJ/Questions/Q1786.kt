//Question No: 1786
//Title: 찾기
//Tier: Platinum V
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
val matchPositions = mutableListOf<Int>()

fun main() = with(br) {
    val text = readLine()
    val pattern = readLine()
    val matchCount = KMP(text, pattern)
    bw.write("$matchCount\n")
    for (position in matchPositions) {
        bw.write("$position\n")
    }
    bw.flush()
    bw.close()
}

fun createPartialMatchTable(pattern: String): IntArray {
    val patternLength = pattern.length
    val table = IntArray(patternLength) { 0 }
    var j = 0
    for (i in 1 until patternLength) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = table[j - 1]
        }
        if (pattern[i] == pattern[j]) {
            table[i] = ++j
        }
    }
    return table
}

fun KMP(text: String, pattern: String): Int {
    val partialMatchTable = createPartialMatchTable(pattern)
    val textLength = text.length
    val patternLength = pattern.length
    var j = 0
    var matchCount = 0
    for (i in 0 until textLength) {
        while (j > 0 && text[i] != pattern[j]) {
            j = partialMatchTable[j - 1]
        }
        if (text[i] == pattern[j]) {
            if (j == patternLength - 1) {
                matchPositions.add(i - patternLength + 2)
                j = partialMatchTable[j]
                matchCount++
            } else {
                j++
            }
        }
    }
    return matchCount
}

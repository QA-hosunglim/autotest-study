package org.example

class MultiplicationTable(private val number: Int) {

    fun calculate(): List<String> {
        val result = mutableListOf<String>()
        for (i in 1..9) {
            result.add("$number x $i = ${number * i}")
        }
        return result
    }

    fun printTable() {
        calculate().forEach { println(it) }
    }
}

fun main() {
    print("출력할 단수를 입력하세요: ")
    val input = readLine()?.toIntOrNull() ?: return println("유효한 숫자를 입력해주세요.")

    val multiplicationTable = MultiplicationTable(input)
    multiplicationTable.printTable()
}

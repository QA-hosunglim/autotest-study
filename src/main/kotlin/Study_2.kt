package org.example

fun main() {
    println("공백으로 구분된 숫자들을 입력하세요:")

    val input = readLine() ?: ""

    val (min, max) = findMinMax(input)

    // 결과를 문자열로 변환하여 출력합니다.
    println("${min ?: "없음"} ${max ?: "없음"}")
}

// 주어진 문자열에서 공백으로 구분된 숫자들의 최소값과 최대값을 찾는 함수
fun findMinMax(s: String): Pair<Int?, Int?> {
    val numbers = s.split(" ").mapNotNull { it.toIntOrNull() }
    val min = numbers.minOrNull()
    val max = numbers.maxOrNull()
    return Pair(min, max)
}

package org.example

// 프로그램의 시작 지점
fun main() {
    // 사용자에게 공백으로 구분된 숫자들을 입력하라는 메시지를 출력합니다.
    println("공백으로 구분된 숫자들을 입력하세요:")

    // 사용자 입력을 읽습니다. 입력이 없을 경우 빈 문자열을 사용합니다.
    val input = readLine() ?: ""

    // 입력된 문자열을 `findMinMax` 함수에 전달하여 최소값과 최대값을 찾습니다.
    val result = findMinMax(input)

    // 결과를 출력합니다.
    println(result)
}

// 주어진 문자열에서 공백으로 구분된 숫자들의 최소값과 최대값을 찾는 함수
fun findMinMax(s: String): String {
    // 문자열을 공백을 기준으로 나누고, 각 요소를 정수로 변환한 후 리스트로 만듭니다.
    val numbers = s.split(" ").map { it.toInt() }

    // 리스트에서 최소값을 찾습니다. 리스트가 비어있을 경우 null을 반환합니다.
    val min = numbers.minOrNull()

    // 리스트에서 최대값을 찾습니다. 리스트가 비어있을 경우 null을 반환합니다.
    val max = numbers.maxOrNull()

    // 최소값과 최대값을 문자열로 변환하여 반환합니다. null 값이 있을 경우 처리하지 않으므로 주의가 필요합니다.
    return "$min $max"
}

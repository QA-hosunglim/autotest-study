//package org.example
//
//// 메인 함수, 프로그램의 시작점
//fun main() {
//    try {
//        // MultiplicationTable 함수를 호출하여 구구단 프로그램 실행
//        MultiplicationTable()
//    } catch (e: Exception) {
//        // 예외가 발생했을 때 오류 메시지를 출력
//        println("예상치 못한 오류가 발생했습니다: ${e.message}")
//    }
//}
//
//// 구구단 출력 함수
//fun MultiplicationTable() {
//    while (true) {
//        // 사용자에게 구구단 단수를 입력하도록 요청
//        println("출력할 구구단 단수를 입력하세요 (1부터 9 사이의 숫자, 종료하려면 'exit' 입력):")
//        val input = readLine()?.trim()  // 입력값을 읽고 공백을 제거, (   4) 입력 시 4단 출력
//
//        // 입력이 비어있거나 유효하지 않은 경우
//        if (input.isNullOrBlank()) { //Null이거나 공백일 때
//            println("입력이 유효하지 않습니다. 다시 시도하세요.")
//            continue
//        }
//
//        // 'exit' 입력 시 프로그램 종료
//        if (input.lowercase() == "exit") {
//            println("프로그램을 종료합니다.")
//            return
//        }
//
//        // 입력값을 정수로 변환
//        val 단수 = input.toIntOrNull()
//
//        // 입력값이 1부터 9 사이의 숫자가 아닌 경우
//        if (단수 == null || 단수 !in 1..9) {
//            println("유효하지 않은 입력입니다. 다시 시도하세요.")
//            continue
//        }
//
//        // 유효한 입력인 경우 구구단 출력
//        println("${단수}단을 출력합니다:")
//        for (i in 1..9) {
//            println("$단수 * $i = ${단수 * i}")
//        }
//    }
//}
package org.example

// 메인 함수: 프로그램의 시작점
fun main() {
    // 예외를 잡아내고 처리하는 간결한 방식으로 구구단 프로그램 실행
    runCatching { MultiplicationTable() }
        .onFailure { println("예상치 못한 오류가 발생했습니다: ${it.message}") }
}

// 구구단 출력 함수
fun MultiplicationTable() {
    while (true) {
        // 사용자에게 구구단 단수를 입력하도록 요청
        println("출력할 구구단 단수를 입력하세요 (1부터 9 사이의 숫자, 종료하려면 'exit' 입력):")
        // 입력값을 읽고 공백을 제거, null인 경우 빈 문자열로 대체
        val input = readLine()?.trim().orEmpty()

        when {
            // 'exit' 입력 시 프로그램 종료
            input.equals("exit", ignoreCase = true) -> { //대소문자 구분 안함
                println("프로그램을 종료합니다.")
                return
            }
            // 입력값이 1부터 9 사이의 숫자인 경우
            input.toIntOrNull()?.takeIf { it in 1..9 } != null -> { //정수만 반환, 조건에 맞지 않으면 Null 반환
                val 단수 = input.toInt()
                println("${단수}단을 출력합니다:")
                // 1부터 9까지 반복하며 구구단 출력
                (1..9).forEach { println("$단수 * $it = ${단수 * it}") }
            }
            // 유효하지 않은 입력인 경우 ()
            else -> println("유효하지 않은 입력입니다. 다시 시도하세요.")
        }
    }
}


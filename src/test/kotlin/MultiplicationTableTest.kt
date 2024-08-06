package org.example

import org.testng.annotations.Test
import org.testng.Assert.assertEquals

class MultiplicationTableTest {

    @Test
    fun testGetTableLastValue() {
        // MultiplicationTable의 단수를 3으로 설정하여 인스턴스를 생성합니다.
        val multiplicationTable = MultiplicationTable(3)

        // getTable 메서드를 호출하여 구구단 결과를 가져옵니다.
        val table = multiplicationTable.calculate()

        // 구구단 결과 리스트의 마지막 항목을 가져옵니다.
        val lastLine = table.last()

        // 마지막 줄에서 결과 숫자를 추출합니다.
        val lastNumber = lastLine.split("=").last().trim().toInt()

        // 마지막 숫자가 27인지 검증합니다.
        assertEquals(lastNumber, 27, "마지막 숫자는 27")
    }
}
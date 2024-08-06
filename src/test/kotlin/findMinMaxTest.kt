package org.example

import org.testng.annotations.Test
import org.testng.Assert.assertEquals

class FindMinMaxTest {

    @Test
    fun testFindMin() {
        // `findMinMax` 함수 호출
        val (min,max) = findMinMax("10 20 30 40 50")

        // 최소값 검증
        assertEquals(min, 10, "최소값은 10이어야 합니다.")
    }

    @Test
    fun testFindMax(){
        val (min,max) = findMinMax("40 12 30 43 23")
        assertEquals(max, 43, "최대값은 43이어야 합니다.")

    }

    @Test
    fun testAdditionMinMax(){
        val (min,max) = findMinMax("5 6 7 8 9")
        val sum = (min ?: 0) + (max ?: 0)
        assertEquals(sum,14,"최소값과 최대값의 합은 14이어야 합니다.")
    }
}
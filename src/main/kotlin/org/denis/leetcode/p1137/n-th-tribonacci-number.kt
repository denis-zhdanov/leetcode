package org.denis.leetcode.p1137

import kotlin.test.assertEquals

fun main() {
    assertEquals(0, tribonacci(0))
    assertEquals(1, tribonacci(1))
    assertEquals(1, tribonacci(2))
    assertEquals(4, tribonacci(4))
    assertEquals(1389537, tribonacci(25))
    assertEquals(2082876103, tribonacci(37))
}

fun tribonacci(n: Int): Int {
    return if (n == 0) {
        0
    } else if (n == 1 || n == 2) {
        1
    } else {
        var t0 = 0
        var t1 = 1
        var t2 = 1
        var tmp = n
        var result = 0
        while (--tmp >= 2) {
            result = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = result
        }
        result
    }
}
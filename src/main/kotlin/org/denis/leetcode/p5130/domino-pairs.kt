package org.denis.leetcode.p5130

import kotlin.test.assertEquals

fun main() {
    assertEquals(1, numEquivDominoPairs(arrayOf(intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(5, 6))))
    assertEquals(3, numEquivDominoPairs(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 2))))
    assertEquals(15, numEquivDominoPairs(arrayOf(intArrayOf(2, 1), intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 2))))
}

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val groupBy = dominoes.map {
        if (it[0] < it[1]) {
            Domino(it[0], it[1])
        } else {
            Domino(it[1], it[0])
        }
    }.groupBy { it }
    return groupBy.values.filter { it.size > 1 }.sumBy {
        it.size * (it.size - 1) / 2
    }
}

data class Domino(val a: Int, val b: Int)
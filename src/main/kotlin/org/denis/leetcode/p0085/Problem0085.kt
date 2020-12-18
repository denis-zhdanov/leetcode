package org.denis.leetcode.p0085

import org.denis.leetcode.parseDoubleCharArray
import kotlin.test.assertEquals
import kotlin.math.max

fun main() {
    assertEquals(6, Solution().maximalRectangle(parseDoubleCharArray("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]")))
    assertEquals(0, Solution().maximalRectangle(emptyArray()))
    assertEquals(0, Solution().maximalRectangle(parseDoubleCharArray("[[\"0\"]]")))
    assertEquals(1, Solution().maximalRectangle(parseDoubleCharArray("[[\"1\"]]")))
    assertEquals(0, Solution().maximalRectangle(parseDoubleCharArray("[[\"0\",\"0\"]]")))
//    assertEquals(6, Solution().maximalRectangle(arrayOf(
//            charArrayOf('1','0','1','0','0'),
//            charArrayOf('1','0','1','1','1'),
//            charArrayOf('1','1','1','1','1'),
//            charArrayOf('1','0','0','1','0')
//    )))
}

class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        var result = 0
        matrix.forEachIndexed { y, rowData ->
            rowData.forEachIndexed { x, c ->
                if (c == '1') {
                    result = max(result, 1)
                    var rightX = x + 1
                    while (rightX < rowData.size && matrix[y][rightX] == '1') {
                        result = max(result, expandDown(matrix, y, x, rightX))
                        rightX++
                    }

                    var bottomY = y + 1
                    while (bottomY < matrix.size && matrix[bottomY][x] == '1') {
                        result = max(result, expandRight(matrix, x, y, bottomY))
                        bottomY++
                    }
                }
            }
        }
        return result
    }

    private fun expandRight(matrix: Array<CharArray>, leftX: Int, topY: Int, bottomY: Int): Int {
        var result = bottomY - topY + 1
        var x = leftX + 1
        while (x < matrix[0].size) {
            var y = topY
            while (y <= bottomY) {
                if (matrix[y][x] != '1') {
                    return result
                }
                y++
            }
            result += bottomY - topY + 1
            x++
        }
        return result
    }

    private fun expandDown(matrix: Array<CharArray>, topY: Int, leftX: Int, rightX: Int): Int {
        var result = rightX - leftX + 1
        var y = topY + 1
        while (y < matrix.size) {
            var x = leftX
            while (x <= rightX) {
                if (matrix[y][x] != '1') {
                    return result
                }
                x++
            }
            result += rightX - leftX + 1
            y++
        }
        return result
    }
}
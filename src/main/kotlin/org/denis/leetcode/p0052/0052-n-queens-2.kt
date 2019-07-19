package org.denis.leetcode.p0052

import org.denis.leetcode.p0051.solveNQueens

fun totalNQueens(n: Int): Int {
    return solveNQueens(n).size
}
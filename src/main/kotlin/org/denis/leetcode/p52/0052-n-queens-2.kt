package org.denis.leetcode.p52

import org.denis.leetcode.p51.solveNQueens

fun totalNQueens(n: Int): Int {
    return solveNQueens(n).size
}
package org.denis.leetcode.p0088

import kotlin.test.assertTrue

fun main() {
    assertTrue(intArrayOf(1, 2, 2, 3, 5, 6).contentEquals(intArrayOf(1, 2, 3, 0, 0, 0).apply {
        Solution().merge(this, 3, intArrayOf(2, 5, 6), 3)
    }))
}

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m + n - 1
        var t1 = m - 1
        var t2 = n - 1
        while (i >= 0) {
            when {
                t1 < 0 -> nums1[i--] = nums2[t2--]
                t2 < 0 -> nums1[i--] = nums1[t1--]
                nums1[t1] > nums2[t2] -> nums1[i--] = nums1[t1--]
                else -> nums1[i--] = nums2[t2--]
            }
        }
    }
}
package org.denis.leetcode

fun parseDoubleCharArray(s: String): Array<CharArray> {
    return s
        .substring(2, s.length - 2)
        .split("],[")
        .map { parseCharArray("[$it]") }
        .toTypedArray()
}

fun parseCharArray(s: String): CharArray {
    return s
        .substring(1, s.length - 1)
        .split(",")
        .filter(String::isNotBlank)
        .map { it[1] }
        .toCharArray()
}

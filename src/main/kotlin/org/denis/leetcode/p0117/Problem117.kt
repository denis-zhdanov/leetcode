package org.denis.leetcode.p0117

import java.util.LinkedList

class Solution {
    fun connect(root: Node?): Node? {
        root ?: return null
        var currentLevel = LinkedList<Node>().apply { this += root }
        var nextLevel = LinkedList<Node>()
        var tmp: LinkedList<Node>
        while (currentLevel.isNotEmpty()) {
            var previous: Node? = null
            while (currentLevel.isNotEmpty()) {
                val node = currentLevel.removeFirst()
                node.left?.let { nextLevel += it }
                node.right?.let { nextLevel += it }
                if (previous != null) {
                    previous.next = node
                }
                previous = node
            }
            tmp = currentLevel
            currentLevel = nextLevel
            nextLevel = tmp
        }
        return root
    }
}

data class Node(
    var `val`: Int = 0,
    var left: Node? = null,
    var right: Node? = null,
    var next: Node? = null
)

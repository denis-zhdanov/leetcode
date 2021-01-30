package org.denis.leetcode

import java.util.*

data class TreeNode(
    var `val`: Int,
    var left: TreeNode?,
    var right: TreeNode?
) {
    constructor(value: Int) : this(value, null, null)

    override fun toString(): String {
        return `val`.toString()
    }

    companion object {

        fun parse(s: String): TreeNode {
            val entries = s.trim().let {
                if (it.startsWith("[")) {
                    it.substring(1)
                } else {
                    it
                }
            }.let {
                if (it.endsWith("]")) {
                    it.substring(0, it.length - 1)
                } else {
                    it
                }
            }.split(",").map(String::trim)
            var left = true
            var root: TreeNode? = null
            val next = LinkedList<TreeNode>()
            var current: TreeNode? = null
            for (entry in entries) {
                val node = if (entry == "null") {
                    null
                } else {
                    TreeNode(entry.toInt())
                }

                when {
                    root == null -> {
                        root = node
                        current = node
                    }
                    left -> {
                        current?.left = node
                        left = false
                        node?.let(next::add)
                    }
                    else -> {
                        current?.right = node
                        left = true
                        node?.let(next::add)
                        if (next.isNotEmpty()) {
                            current = next.removeFirst()
                        }
                    }
                }
            }
            return root as TreeNode
        }
    }
}
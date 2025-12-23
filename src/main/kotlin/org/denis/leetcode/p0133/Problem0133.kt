package org.denis.leetcode.p0133

import java.util.Stack

fun main() {

}

class Solution {
    @Suppress("unused")
    fun cloneGraph(node: Node?): Node? {
        node ?: return node
        val inputNodes = mutableMapOf<Int, Node>()
        val resultNodes = mutableMapOf<Int, Node>()
        val filled = mutableSetOf<Int>()
        val inputToProcess = Stack<Node>()
        inputToProcess.push(node)
        while (inputToProcess.isNotEmpty()) {
            val inputNode = inputToProcess.pop()
            inputNodes[inputNode.`val`] = inputNode
            val resultNode = resultNodes.computeIfAbsent(inputNode.`val`) {
                Node(it)
            }

            if (!filled.add(inputNode.`val`)) {
                continue
            }

            inputNode.neighbors.forEach { inputNeighbour ->
                if (inputNeighbour != null) {
                    inputToProcess.push(inputNeighbour)
                    resultNode.neighbors += resultNodes.computeIfAbsent(inputNeighbour.`val`) {
                        Node(it)
                    }
                }

            }
        }
        return resultNodes[node.`val`]
    }
}

data class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}
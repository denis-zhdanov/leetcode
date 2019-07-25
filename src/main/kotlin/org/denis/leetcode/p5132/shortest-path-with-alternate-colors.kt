package org.denis.leetcode.p5132

import kotlin.math.min
import kotlin.test.assertEquals

fun main() {
    assertArraysEquals(intArrayOf(0,5,3,1,8,1,5,2,2),
                       shortestAlternatingPaths(9,
                                                arrayOf(intArrayOf(1, 8),
                                                        intArrayOf(5, 7),
                                                        intArrayOf(1, 2),
                                                        intArrayOf(2, 2),
                                                        intArrayOf(7, 4),
                                                        intArrayOf(7, 2),
                                                        intArrayOf(3, 8),
                                                        intArrayOf(7, 0),
                                                        intArrayOf(1, 5),
                                                        intArrayOf(2, 7),
                                                        intArrayOf(2, 3),
                                                        intArrayOf(6, 3),
                                                        intArrayOf(3, 0),
                                                        intArrayOf(4, 8),
                                                        intArrayOf(7, 5),
                                                        intArrayOf(1, 6),
                                                        intArrayOf(3, 7)),
                                                arrayOf(intArrayOf(2, 1),
                                                        intArrayOf(1, 4),
                                                        intArrayOf(0, 3),
                                                        intArrayOf(0, 5),
                                                        intArrayOf(1, 5),
                                                        intArrayOf(8, 2),
                                                        intArrayOf(5, 8),
                                                        intArrayOf(2, 6),
                                                        intArrayOf(5, 3),
                                                        intArrayOf(6, 7),
                                                        intArrayOf(4, 0),
                                                        intArrayOf(2, 2))))
    assertArraysEquals(intArrayOf(0, 1, 3, -1, 4, 3),
                       shortestAlternatingPaths(6,
                                                arrayOf(intArrayOf(1, 5),
                                                        intArrayOf(2, 2),
                                                        intArrayOf(5, 5),
                                                        intArrayOf(3, 0),
                                                        intArrayOf(4, 5),
                                                        intArrayOf(2, 4),
                                                        intArrayOf(4, 1),
                                                        intArrayOf(1, 0),
                                                        intArrayOf(1, 2),
                                                        intArrayOf(5, 2),
                                                        intArrayOf(2, 3),
                                                        intArrayOf(0, 1)),
                                                arrayOf(intArrayOf(4, 4),
                                                        intArrayOf(2, 5),
                                                        intArrayOf(1, 1),
                                                        intArrayOf(5, 4),
                                                        intArrayOf(3, 3))))
    assertArraysEquals(intArrayOf(0, 2, -1, -1, 1),
                       shortestAlternatingPaths(5,
                                                arrayOf(intArrayOf(3, 2),
                                                        intArrayOf(4, 1),
                                                        intArrayOf(1, 4),
                                                        intArrayOf(2, 4)),
                                                arrayOf(intArrayOf(2, 3),
                                                        intArrayOf(0, 4),
                                                        intArrayOf(4, 3),
                                                        intArrayOf(4, 4),
                                                        intArrayOf(4, 0),
                                                        intArrayOf(1, 0))))
    assertArraysEquals(intArrayOf(0, 1, 2, 3, 7),
                       shortestAlternatingPaths(5,
                                                arrayOf(intArrayOf(0, 1),
                                                        intArrayOf(1, 2),
                                                        intArrayOf(2, 3),
                                                        intArrayOf(3, 4)),
                                                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))))
    assertArraysEquals(intArrayOf(0, 1, 2, 1, 1),
                       shortestAlternatingPaths(5,
                                                arrayOf(intArrayOf(2, 2),
                                                        intArrayOf(0, 1),
                                                        intArrayOf(0, 3),
                                                        intArrayOf(0, 0),
                                                        intArrayOf(0, 4),
                                                        intArrayOf(2, 1),
                                                        intArrayOf(2, 0),
                                                        intArrayOf(1, 4),
                                                        intArrayOf(3, 4)),
                                                arrayOf(intArrayOf(1, 3),
                                                        intArrayOf(0, 0),
                                                        intArrayOf(0, 3),
                                                        intArrayOf(4, 2),
                                                        intArrayOf(1, 0))))
    assertArraysEquals(intArrayOf(0, 1, 3, 2, 4),
                       shortestAlternatingPaths(5,
                                                arrayOf(intArrayOf(0, 1),
                                                        intArrayOf(3, 2),
                                                        intArrayOf(1, 0),
                                                        intArrayOf(4, 3),
                                                        intArrayOf(2, 4)),
                                                arrayOf(intArrayOf(2, 4), intArrayOf(2, 2), intArrayOf(1, 3))))
    assertArraysEquals(intArrayOf(0, 1, -1),
                       shortestAlternatingPaths(3,
                                                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)),
                                                emptyArray()))
    assertArraysEquals(intArrayOf(0, 1, -1),
                       shortestAlternatingPaths(3,
                                                arrayOf(intArrayOf(0, 1)),
                                                arrayOf(intArrayOf(2, 1))))
    assertArraysEquals(intArrayOf(0, -1, -1),
                       shortestAlternatingPaths(3,
                                                arrayOf(intArrayOf(1, 0)),
                                                arrayOf(intArrayOf(2, 1))))
    assertArraysEquals(intArrayOf(0, 1, 2),
                       shortestAlternatingPaths(3,
                                                arrayOf(intArrayOf(0, 1)),
                                                arrayOf(intArrayOf(1, 2))))
    assertArraysEquals(intArrayOf(0, 1, 1),
                       shortestAlternatingPaths(3,
                                                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)),
                                                arrayOf(intArrayOf(1, 0))))
}

private fun assertArraysEquals(i1: IntArray, i2: IntArray) {
    assertEquals(i1.size, i2.size, "lengths mismatch")
    (0 until i1.size).forEach {
        assertEquals(i1[it], i2[it], "mismatch at index $it")
    }
}

fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
    val result = mutableMapOf<Node, MutableSet<Route>>()
    val allEdges = red_edges.flatMap {
        buildEdges(it[0], it[1], 1, 0)
    } + blue_edges.flatMap {
        buildEdges(it[0], it[1], 0, 1)
    }
    val edgesByTo = allEdges.groupBy { it.to }
    result[Node(0, 0)] = mutableSetOf(Route(mutableSetOf(Node(0, 0)), 0))
    result[Node(0, 1)] = mutableSetOf(Route(mutableSetOf(Node(0, 1)), 1))
    ((n - 1) downTo 1).forEach {
        solve(Node(it, 0), edgesByTo, result, mutableSetOf())
        solve(Node(it, 1), edgesByTo, result, mutableSetOf())
    }
    return (0 until n).map { id ->
        val a = result[Node(id, 0)]?.filter { it.path.isNotEmpty() }?.minBy { it.path.size }?.path?.size ?: 0
        val b = result[Node(id, 1)]?.filter { it.path.isNotEmpty() }?.minBy { it.path.size }?.path?.size ?: 0
        if (a > 0 && b > 0) {
            min(a, b) - 1
        } else if (a <= 0) {
            b - 1
        } else {
            a - 1
        }
    }.toIntArray()
}

fun buildEdges(from: Int, to: Int, colorFrom: Int, colorTo: Int): Collection<Edge> {
    if (to == 0) {
        return emptyList()
    }
    return if (from == 0) {
        listOf(Edge(Node(from, colorFrom), Node(to, colorTo)))
    } else {
        listOf(Edge(Node(from, colorFrom), Node(to, colorTo)))
    }
}

fun solve(
        currentNode: Node,
        edgesByTo: Map<Node, List<Edge>>,
        routes: MutableMap<Node, MutableSet<Route>>,
        inProgress: MutableSet<Node>
): Boolean {
    routes[currentNode]?.let {
        return true
    }
    if (inProgress.contains(currentNode)) {
        return false
    }
    val edges = edgesByTo[currentNode]
    if (edges == null) {
        routes[currentNode] = mutableSetOf(Route(emptySet(), 2))
        return true
    }

    inProgress += currentNode
    var foundNonCycle = false
    var cycleDetected = false
    for (edge in edges) {
        val ok = solve(edge.from, edgesByTo, routes, inProgress)
        if (ok) {
            foundNonCycle = true
            routes[edge.from]?.filter { route ->
                route.endColor != edge.to.color && route.path.isNotEmpty() && !route.path.contains(currentNode)
            }?.filter { it.path.isNotEmpty() }?.forEach {
                routes.getOrPut(currentNode) { mutableSetOf() }.add(Route(it.path + currentNode, currentNode.color))
            }
        } else {
            cycleDetected = true
        }
    }
    inProgress.remove(currentNode)

    if (!cycleDetected && routes[currentNode] == null) {
        routes[currentNode] = mutableSetOf(Route(emptySet(), 2))
    }
    return foundNonCycle
}

data class Edge(val from: Node, val to: Node)
data class Node(val id: Int, val color: Int)
data class Route(val path: Set<Node>, val endColor: Int)
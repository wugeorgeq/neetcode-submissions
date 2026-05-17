/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    /**
    i guess we hash them in a list to ensure we're referencing properly?

    bfs with fifo to visit?

    queue is always the original node. copying needs the table.
    */
    fun cloneGraph(node: Node?): Node? {
        val table = Array<Node?>(100) { null }
        val queue = ArrayDeque<Pair<Node, Node>>()
        if (node == null) return node
        val firstNode = Node(`val` = node.`val`)
        table[1] = firstNode
        queue.addLast(Pair(node, firstNode))
        while (queue.isNotEmpty()) {
            val (ogNode, newNode) = queue.removeFirst()
            for (neighbor in ogNode.neighbors) {
                if (table[neighbor!!.`val`] == null) {
                    val newNeighbor = Node(`val` = neighbor!!.`val`)
                    table[neighbor!!.`val`] = newNeighbor
                    newNode.neighbors.add(newNeighbor)
                    queue.addLast(Pair(neighbor, newNeighbor))
                } else {
                    newNode.neighbors.add(table[neighbor!!.`val`])
                }
            }
        }
        return firstNode
    }
}

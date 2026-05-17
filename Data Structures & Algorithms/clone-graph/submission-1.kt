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
            for (ogNeighbor in ogNode.neighbors) {
                val index = ogNeighbor!!.`val`
                // for neighbors, if we've cached it, then we acutally
                //  already have its list of neighbors
                if (table[index] == null) {
                    val newNeighbor = Node(`val` = index)
                    table[index] = newNeighbor
                    newNode.neighbors.add(newNeighbor)
                    queue.addLast(Pair(ogNeighbor, newNeighbor))
                } else {
                    // if this is our first time seeing this neighbor,
                    //  add to queue to process its neighbors
                    newNode.neighbors.add(table[index])
                }
            }
        }
        return firstNode
    }
}

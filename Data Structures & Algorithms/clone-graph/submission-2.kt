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
        if (node == null) return null
        // Map: Original Node -> Cloned Node
        val visited = mutableMapOf<Node, Node>()
        
        // Initialize the first clone
        visited[node] = Node(node.`val`)
        
        val queue = ArrayDeque<Node>()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            // Iterate through the original node's neighbors
            for (neighbor in curr.neighbors) {
                if (neighbor == null) continue
                
                if (neighbor !in visited) {
                    // 1. Create the clone if we haven't seen it
                    visited[neighbor] = Node(neighbor.`val`)
                    // 2. Add original to queue to process its neighbors later
                    queue.add(neighbor)
                }
                
                // 3. Connect the clones: 
                // curr's clone -> neighbor's clone
                visited[curr]?.neighbors?.add(visited[neighbor])
            }
        }

        return visited[node]
    }
}

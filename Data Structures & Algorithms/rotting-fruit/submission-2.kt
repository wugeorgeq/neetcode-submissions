class Solution {
    /**
    each minute we mark all neighbors as rotten until there are no fresh fruits
    do we have a set of fresh fruit?
    set of rotten fruit?

    how do we remove from queue and also maintain distance or time?
    */
    data class Orange(val x: Int, val y: Int, val time: Int)
    val neighbors = listOf(
        0 to 1,
        0 to -1,
        -1 to 0,
        1 to 0,
    )
    fun orangesRotting(grid: Array<IntArray>): Int {
        val fresh = mutableSetOf<Pair<Int,Int>>()
        val queue = ArrayDeque<Orange>()
        var minute = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 2) {
                    queue.addLast(Orange(i,j,0))
                }
                if (grid[i][j] == 1) fresh.add(i to j)
            }
        }
        while (!queue.isEmpty()) {
            val curr = queue.removeFirst()
            minute = minute.coerceAtLeast(curr.time)
            neighbors.forEach { n ->
                val i = curr.x + n.first
                val j = curr.y + n.second
                if (i in grid.indices && j in grid[0].indices && grid[i][j] == 1) {
                    queue.addLast(Orange(i,j,curr.time+1))
                    fresh.remove(Pair(i,j))
                    grid[i][j] = 2
                }
            }
        }
        return if (fresh.isEmpty()) minute else -1
    }
}

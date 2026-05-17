class Solution {
    /**
    need to mark cells as visited when doing bfs for "this island"
    can we share visited markers? i guess?

    yea ... we can share visited markers because i think we have to recurse through
    every cell to ensure we found all islands


    */
    fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == '1') {
                    islandCount++
                    grid[i][j] = '0'
                    bfs(Pair(i,j), grid)
                }
            }
        }
        return islandCount
    }

    val neighbors = listOf(
        Pair(0, -1),
        Pair(-1, 0),
        Pair(0, 1),
        Pair(1, 0),
    )
    fun bfs(start: Pair<Int, Int>, grid: Array<CharArray>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(start)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            for ((i,j) in neighbors) {
                val x = current.first + i
                val y = current.second + j
                if (x in grid.indices && y in grid[x].indices && grid[x][y] == '1') {
                    grid[x][y] = '0'
                    queue.addLast(Pair(x, y))
                }
            }
        }
    }
}

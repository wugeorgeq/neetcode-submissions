class Solution {
    /**
    go through entire grid, visiting islands and counting area size as i go
    */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxIslandSize = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0
                    val size = bfs(Pair(i,j), grid)
                    maxIslandSize = maxIslandSize.coerceAtLeast(size)
                }
            }
        }
        return maxIslandSize
    }

    val neighbors = listOf(
        Pair(0, -1),
        Pair(-1, 0),
        Pair(0, 1),
        Pair(1, 0),
    )
    fun bfs(start: Pair<Int, Int>, grid: Array<IntArray>): Int {
        var islandSize = 1
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(start)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            for ((i,j) in neighbors) {
                val x = current.first + i
                val y = current.second + j
                if (x in grid.indices && y in grid[x].indices && grid[x][y] == 1) {
                    grid[x][y] = 0
                    queue.addLast(Pair(x, y))
                    islandSize++
                }
            }
        }
        return islandSize
    }
}

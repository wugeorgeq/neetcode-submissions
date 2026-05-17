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

    fun bfs(start: Pair<Int, Int>, grid: Array<CharArray>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(start)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val i = current.first
            val j = current.second
            if (i > 0) {
                if (grid[i-1][j] == '1') {
                    grid[i-1][j] = '0'
                    queue.addLast(Pair(i-1, j))
                }
            }
            if (j > 0) {
                if (grid[i][j-1] == '1') {
                    grid[i][j-1] = '0'
                    queue.addLast(Pair(i, j-1))
                }
            }
            if (i < grid.size - 1) {
                if (grid[i+1][j] == '1') {
                    grid[i+1][j] = '0'
                    queue.addLast(Pair(i+1, j))
                }
            }
            if (j < grid[i].size - 1) {
                if (grid[i][j+1] == '1') {
                    grid[i][j+1] = '0'
                    queue.addLast(Pair(i, j+1))
                }
            }
        }
    }
}

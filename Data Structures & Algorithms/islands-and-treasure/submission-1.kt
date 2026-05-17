const val INF = 2147483647
class Solution {
    /**
    ok bfs is how we get to the nearest treasure that's for sure ...
    ah interesting, i could fill from each treasure chest... but taht would take a while

    so i guess as i'm going from land to closest treasure via bfs i should be able to fill values on the way?
    but do i trust them when they're filled in? yes right?

    dang i had the intuition and everything ... 
    */

    val ni = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    fun islandsAndTreasure(grid: Array<IntArray>) {
        // do bfs from every treasure
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                val curr = grid[i][j]
                if (curr == 0) {
                    queue.addLast(Triple(i, j, 0))
                }
            }
        }
        while (!queue.isEmpty()) {
            val (i, j, dist) = queue.removeFirst()
            if (grid[i][j] == INF) {
                grid[i][j] = dist
            }
            for ((x, y) in ni) {
                val nx = i + x
                val ny = j + y
                val validNeighbor = nx in grid.indices && ny in grid[0].indices
                if (validNeighbor && grid[nx][ny] == INF) {
                    queue.addLast(Triple(nx,ny, dist+1))
                }
            }
        }
    }


    /**
    Begin O(n^4) solution
    */
    /*
    val ni = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    fun islandsAndTreasure(grid: Array<IntArray>) {
        // loop through all of grid
        // in each loop, perform bfs if this cell is INF
        //     using queue fifo 
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                val curr = grid[i][j]
                if (curr == INF) {
                    grid[i][j] = bfs(i, j, grid)
                }
            }
        }
    }

    fun bfs(i: Int, j: Int, grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        queue.addLast(Triple(i, j, 0))
        visited.add(i to j)
        
        while (queue.isNotEmpty()) {
            val (cx, cy, dist) = queue.removeFirst()
            if (grid[cx][cy] == 0) return dist
            for ((x, y) in ni) {
                val nx = cx + x
                val ny = cy + y
                val validNeighbor = nx in grid.indices && ny in grid[0].indices
                if (validNeighbor && grid[nx][ny] != -1 && Pair(nx, ny) !in visited) {
                    queue.addLast(Triple(nx,ny, dist+1))
                    visited.add(nx to ny)
                }
            }
        }
        return INF
    }
    */
}

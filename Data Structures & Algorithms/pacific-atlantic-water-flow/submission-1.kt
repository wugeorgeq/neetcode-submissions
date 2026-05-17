class Solution {
    /**
    ok so water flows in all directions. given taht we can do bfs/dfs "backwards"
    and fill in a grid with flowable from all borders
    then continue to search for >= cells and mark them as flowable until all are
    visited. i need to mark cells as not visited, visited and flowable and visited
    and not flowable
    */
    data class DataPoint(val visited: Boolean, val flowable: Boolean, val x: Int, val y: Int)
    val neighbors = listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val pacificData = Array<Array<DataPoint>>(heights.size) { 
            Array(heights[0].size) { DataPoint(false, false, 0, 0) }
        }
        val atlData = Array<Array<DataPoint>>(heights.size) { 
            Array(heights[0].size) { DataPoint(false, false, 0, 0) }
        }
        val pacQueue = ArrayDeque<DataPoint>()
        val atlQueue = ArrayDeque<DataPoint>()
        for (i in 0 until heights.size) {
            pacificData[i][0] = DataPoint(true, true, i, 0)
            pacQueue.addLast(pacificData[i][0])
        }
        for (j in 0 until heights[0].size) {
            pacificData[0][j] = DataPoint(true, true, 0, j)
            pacQueue.addLast(pacificData[0][j])
        }
        for (i in heights.size - 1 downTo 0) {
            atlData[i][heights[0].size - 1] = DataPoint(true, true, i, heights[0].size - 1)
            atlQueue.addLast(atlData[i][heights[0].size - 1])
        }
        for (j in heights[0].size - 1 downTo 0) {
            atlData[heights.size - 1][j] = DataPoint(true, true, heights.size - 1, j)
            atlQueue.addLast(atlData[heights.size - 1][j])
        }
        while (pacQueue.isNotEmpty()) {
            val curr = pacQueue.removeFirst()
            neighbors.forEach {
                val x = curr.x + it.first
                val y = curr.y + it.second
                if (x in heights.indices && y in heights[0].indices) {
                    if (!pacificData[x][y].visited) {
                        if (heights[x][y] >= heights[curr.x][curr.y]) {
                            pacQueue.addLast(DataPoint(true, true, x, y))
                            pacificData[x][y] = DataPoint(true, true, x, y)
                        }
                    }
                }
            }
        }
        while (atlQueue.isNotEmpty()) {
            val curr = atlQueue.removeFirst()
            neighbors.forEach {
                val x = curr.x + it.first
                val y = curr.y + it.second
                if (x in heights.indices && y in heights[0].indices) {
                    if (!atlData[x][y].visited ) {
                        if (heights[x][y] >= heights[curr.x][curr.y]) {
                            atlQueue.addLast(DataPoint(true, true, x, y))
                            atlData[x][y] = DataPoint(true, true, x, y)
                        }
                    }
                }
            }
        }
        val toReturn = mutableListOf<List<Int>>()
        for (i in 0 until heights.size) {
            for (j in 0 until heights[i].size) {
                if (pacificData[i][j].flowable && atlData[i][j].flowable) {
                    toReturn.add(listOf(i,j))
                }
            }
        }
        return toReturn

    /**
    oh wow this is wrong because water can flow in 4 directions, not just towards the oceans directly

    naievely, for each cell, dfs until pacific or atlantic oceans and then we're good
    or, paths from pacific to atalantic in ascending then descending fashion
    while dfs-ing to the oceans, mark cells along the way recursively up the stack
    start from outside-in, marking cells as flowable to ocean

    it would only take 2 full accesses to determine flowability because we can build it
    up 2d fashion
    val pacificNeighbors = listOf(-1 to 0, 0 to -1)
    val atlNeighbors = listOf(1 to 0, 0 to 1)
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val pacific = Array<IntArray>(heights.size) {IntArray(heights[0].size)}
        for (i in 0 until heights.size) {
            for (j in 0 until heights[i].size) {
                if (i == 0 || j == 0) {
                    println("setting pacific $i $j")
                    pacific[i][j] = 1
                } else {
                    val ns = pacificNeighbors.map {
                        Pair(i + it.first, j + it.second)
                    }
                    if (ns.any { 
                        heights[it.first][it.second] <= heights[i][j] &&
                        pacific[it.first][it.second] == 1
                    }) {
                        println("setting pacific $i $j")
                        pacific[i][j] = 1
                    }
                }
            }
        }
        val atl = Array<IntArray>(heights.size) {IntArray(heights[0].size)}
        for (i in heights.size - 1 downTo 0) {
            for (j in heights[i].size - 1 downTo 0) {
                if (i == heights.size - 1 || j == heights[i].size - 1) {
                    println("setting atl $i $j")
                    atl[i][j] = 1
                } else {
                    val ns = atlNeighbors.map {
                        Pair(i + it.first, j + it.second)
                    }
                    if (ns.any {
                        heights[it.first][it.second] <= heights[i][j] &&
                        atl[it.first][it.second] == 1 
                    }) {
                        println("setting atl $i $j")
                        atl[i][j] = 1
                    }
                }
            }
        }
        val toReturn = mutableListOf<MutableList<Int>>()
        for (i in 0 until heights.size) {
            for (j in 0 until heights[i].size) {
                if (pacific[i][j] == 1 && atl[i][j] == 1) {
                    toReturn.add(mutableListOf(i, j))
                }
            }
        }
        return toReturn
    */
    }
}

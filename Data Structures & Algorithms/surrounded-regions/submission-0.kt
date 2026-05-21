class Solution {
    /**
    if an o is accessible via border, then it is not going to be flipped. therefore we can perform
    bfs/dfs from the border to mark coordinates as "stable"
    */
    val neighbors = listOf(
        -1 to 0,
        1 to 0,
        0 to 1,
        0 to -1,
    )

    fun solve(board: Array<CharArray>) {
        val visited = mutableSetOf<Pair<Int, Int>>()
        for (i in 0 until board.size) {
            val left = Pair(i, 0)
            val right = Pair(i, board[0].size - 1)
            if (!visited.contains(left) && board[left.first][left.second] == 'O') {
                bfs(board, left, visited)
            }
            if (!visited.contains(right) && board[right.first][right.second] == 'O') {
                bfs(board, right, visited)
            }
        }
        for (j in 0 until board[0].size) {
            val top = Pair(0, j)
            val bottom = Pair(board.size - 1, j)
            if (!visited.contains(top) && board[top.first][top.second] == 'O') {
                bfs(board, top, visited)
            }
            if (!visited.contains(bottom) && board[bottom.first][bottom.second] == 'O') {
                bfs(board, bottom, visited)
            }
        }
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (board[i][j] == 'O' && !visited.contains(Pair(i,j))) {
                    board[i][j] = 'X'
                }
            }
        }
    }

    fun bfs(board: Array<CharArray>, start: Pair<Int, Int>, visited: MutableSet<Pair<Int, Int>>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(start)
        visited.add(start)
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            neighbors.forEach { coord ->
                val i = curr.first + coord.first
                val j = curr.second + coord.second
                val neighbor = Pair(i, j)
                if (!visited.contains(neighbor) && i in 0 until board.size && j in 0 until board[0].size &&
                board[i][j] == 'O') {
                    visited.add(neighbor)
                    queue.addLast(neighbor)
                }
            }
        }
    }
}

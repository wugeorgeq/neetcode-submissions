class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // if i have all 9 in a list then i can just check for duplicates
        // can use a simple arr to check for duplicates

        // construct list of lists for "each section"
        val sections = mutableListOf<CharArray>()
        board.forEach { arr ->
            sections.add(arr)
        }

        val arr = Array<MutableList<Char>>(9) { mutableListOf() }
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                arr[i].add(board[j][i])
            }
        }
        arr.forEach { sections.add(it.toCharArray()) }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val currArr = mutableListOf<Char>()
                for (x in 0 until 3) {
                    for (y in 0 until 3) {
                        currArr.add(
                            board[3*i + x][3*j + y]
                        )
                    }
                }
                sections.add(currArr.toCharArray())
            }
        }

        fun isValidArr(input: CharArray): Boolean {
            val table = IntArray(9)
            input.forEach {
                if (it != '.') {
                    val num = it.digitToInt()
                    if (table[num-1] == 1) return false
                    table[num-1] = 1
                }
            }
            return true
        }

        return sections.all { isValidArr(it) }
    }
}

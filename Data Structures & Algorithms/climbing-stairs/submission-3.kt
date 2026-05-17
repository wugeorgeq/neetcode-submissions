class Solution {
    fun climbStairs(n: Int): Int {
        fun dfs(x: Int): Int {
            val table = IntArray(x+1)
            table[0] = 1
            table[1] = 2
            for (i in 2 until x) {
                table[i] = table[i-1] + table[i-2]
            }
            return table[x-1]
        }
        return dfs(n)
    }
}

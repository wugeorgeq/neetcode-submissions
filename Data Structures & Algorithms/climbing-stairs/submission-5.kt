class Solution {
    fun climbStairs(n: Int): Int {
        /**
        lets try bottoms up DP

        here we can build up the array and after done we simply return
        dp[n] ... or dp[n-1] after building it up

        so it'll be [1, 2, x, y, z] where we're indexing by n-1
        and each dp[n] = dp[n-1] + dp[n-2]
        */

        if (n <= 2) return n
        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2
        for (i in 2 until n) {
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n-1]

        /**
        with 1 step, it's 1 way
        with 2 steps, it's 2 ways
        meaning with 3 steps left it's 1,1,1 1,2 2,1 3 ways
        3 steps = sol(1) + sol(2) because it's 3-1 and 3-2

        do we memoize all the existing solutions and build up from there?

        sol(4) = sol(3) + sol(2) = sol(1) + sol(2) + sol(2)

        ok memoized recursion is cool ... but need DP solution
        val arr = IntArray(maxOf(2, n)) { -1 }
        arr[0] = 1
        arr[1] = 2
        fun recurse(n: Int): Int {
            if (arr[n-1] != -1) return arr[n-1]
            val sol = recurse(n - 1) + recurse(n - 2)
            arr[n-1] = sol
            return sol
        }
        return recurse(n)

        */
    }
}

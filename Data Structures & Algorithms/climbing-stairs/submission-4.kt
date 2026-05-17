class Solution {
    fun climbStairs(n: Int): Int {
        /**
        with 1 step, it's 1 way
        with 2 steps, it's 2 ways
        meaning with 3 steps left it's 1,1,1 1,2 2,1 3 ways
        3 steps = sol(1) + sol(2) because it's 3-1 and 3-2

        do we memoize all the existing solutions and build up from there?

        sol(4) = sol(3) + sol(2) = sol(1) + sol(2) + sol(2)
        */
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
    }

}

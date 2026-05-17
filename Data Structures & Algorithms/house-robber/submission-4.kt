class Solution {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var prev2 = 0
        var prev1 = 0
        for (num in nums) {
            val current = maxOf(prev2 + num, prev1)
            prev2 = prev1
            prev1 = current
        }
        return maxOf(prev2, prev1)
    }

    /**
        try by instantiating from 0 and running through the whole list
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var prev2 = nums[0]
        var prev1 = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            val current = maxOf(prev2 + nums[i], prev1)
            prev2 = prev1
            prev1 = current
        }
        return maxOf(prev2, prev1)
    }
    */
    /**
    probably something like dp[n] is max amount at index n
    at each index n, dp[n] = max(dp[n-1], nums[n] + dp[n-2])

    oh wait let's do the non array version too
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i-1], nums[i] + dp[i-2])
        }
        return dp[nums.size - 1]
    }

    */
}

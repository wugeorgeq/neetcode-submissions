class Solution {
    /**
    probably something like dp[n] is max amount at index n
    at each index n, dp[n] = max(dp[n-1], nums[n] + dp[n-2])
    */
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
}

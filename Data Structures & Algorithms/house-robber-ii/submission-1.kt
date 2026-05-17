class Solution {
    /**
    do i just run house robbers algo on the array except the last index
    and except the first index?
    */
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(rob(nums, 1, nums.size), rob(nums, 0, nums.size - 1))
    }

    // 1, 3
    fun rob(nums: IntArray, startIndex: Int, endIndex: Int): Int {
        if (endIndex - startIndex <= 1) return nums[startIndex]
        var prev2 = nums[startIndex]
        var prev1 = maxOf(nums[startIndex], nums[startIndex + 1])
        for (i in startIndex + 2 until endIndex) {
            val current = maxOf(prev2 + nums[i], prev1)
            prev2 = prev1
            prev1 = current
        }
        return maxOf(prev2, prev1)
    }
}

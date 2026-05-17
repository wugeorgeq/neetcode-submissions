class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var i = 0
        var j = nums.size - 1
        while (i <= j) {
            val mid = i + (j - i) / 2
            if (nums[mid] == target) return mid
            if (target <= nums[mid]) {
                j = mid - 1
            } else {
                i = mid + 1
            }
        }
        return -1
    }
}

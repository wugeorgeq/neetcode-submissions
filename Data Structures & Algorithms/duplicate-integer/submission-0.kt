class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numsSet = mutableSetOf<Int>()
        nums.forEach { current ->
            if (numsSet.contains(current)) {
                return true
            }
            numsSet.add(current)
        }
        return false
    }
}

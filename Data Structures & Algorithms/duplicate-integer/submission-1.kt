class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        // think about the fact that adding to a set returns false when its already there
        val seen = mutableSetOf<Int>()
        return nums.any { !seen.add(it) }

        // think about what's kotliny george
        // compare sizes of sets
        // return nums.distinct().size < nums.size
        
        // java esque solution
        /**
        val numsSet = mutableSetOf<Int>()
        nums.forEach { current ->
            if (numsSet.contains(current)) {
                return true
            }
            numsSet.add(current)
        }
        return false
        */
    }
}

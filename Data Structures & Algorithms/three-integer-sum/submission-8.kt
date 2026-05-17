class Solution {
    /**
    is this looking for all pairs that form the complement of me, i.e.
    for me at 2, i'm looking for j and k where nums[j] + nums[k] == -2

    gets weird with the duplicates thing ... unless i sort? somehow?
    
    i guess if i continue to mutate a map where i remove myself from it i can loop through
    to find the sum complement ...

    well we can handle the duplicates by sorting before inserting and then checking ...
    deep equality? no ... equality of lists should be fine cuz it's one layer deep?

    if i sort first ...

    [-6,-3,-1,0,4,8,9]

    oh whaaaattt distinct values that sum to 0 not distinct indices ...
    
    ok ... for each number until num is positive so 
    */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val triplets = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            val a = nums[i]
            if (a > 0) break
            if (i > 0 && a == nums[i - 1]) continue

            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val target = -1 * a
                when {
                    nums[j] + nums[k] > target -> k--
                    nums[j] + nums[k] < target -> j++
                    else -> {
                        triplets.add(listOf(a, nums[j], nums[k]))
                        // Critical: Skip duplicates for the second and third numbers
                        while (j < k && nums[j] == nums[j + 1]) j++
                        while (j < k && nums[k] == nums[k - 1]) k--
                        j++
                        k--
                    }
                }
            }
        }
        return triplets
    }
}

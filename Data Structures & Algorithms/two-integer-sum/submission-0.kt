class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val toReturn = IntArray(2)
        val mapValueToIndex = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, value ->
            if (mapValueToIndex.containsKey(target - value)) {
                val otherIndex = mapValueToIndex[target - value]!!
                if (otherIndex < i) {
                    toReturn[0] = otherIndex
                    toReturn[1] = i
                } else {
                    toReturn[1] = otherIndex
                    toReturn[0] = i
                }
            }
            mapValueToIndex[value] = i
        }
        return toReturn
    }
}

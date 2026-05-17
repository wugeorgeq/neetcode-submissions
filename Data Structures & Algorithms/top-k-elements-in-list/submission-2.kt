class Solution {
    /**
        use group to convert list of ints to map of value to frequency
        then map to list and sort that list by frequency, then map to just the value
        and take sublist of 0 until k

        sorting is O(nlogn) and then sublist is O(k)
        O(nlogn) + O(k) or just O(nlogn) where n is size of nums
    */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        return nums.toList()
        .groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .take(k)
        .map { it.key }
        .toIntArray()

        /*
        return nums.toList().groupingBy { it }.eachCount().toList()
            .sortedByDescending { it.second }.map {it.first}.subList(0,k).toIntArray()
            */
    }
}

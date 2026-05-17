class Solution {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // map of value to frequency
        val map = nums.toList().groupingBy { it }.eachCount()
        // buckets indexed by frequency
        // val buckets = mutableListOf<MutableList<Int>>()
        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }
        // what structure to use because the list is bounded by size k ...
        // mutable list with .add() ? or array of size k?
        map.entries.forEach { entry ->
            buckets[entry.value].add(entry.key)
        }
        val toReturn = IntArray(k)
        var count = k - 1
        var outerCount = buckets.size - 1
        while (outerCount >= 0) {
            buckets[outerCount].forEach {
                toReturn[count] = it
                if (count == 0) return toReturn
                count--
            }
            outerCount--
        }
        throw IllegalStateException("no solution")
    /**
    bucket sort
    array of length n where frequency is the index. but what about duplicates?
    do we just have an array of arrays?
    how do we lookup the current count in O(1) for the array of arrays?
    hash value to count?

    ok then assuming we have all these structures, then we can simply grab the 
    last k from the array right?

    hint from gemini is build the map first then distribute to buckets after
    */



    /**
        use group to convert list of ints to map of value to frequency
        then map to list and sort that list by frequency, then map to just the value
        and take sublist of 0 until k

        sorting is O(nlogn) and then sublist is O(k)
        O(nlogn) + O(k) or just O(nlogn) where n is size of nums
    */

/*
        return nums.toList()
            .groupingBy { it }
            .eachCount()
            .entries
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }
            .toIntArray()

            */

        /*
        return nums.toList().groupingBy { it }.eachCount().toList()
            .sortedByDescending { it.second }.map {it.first}.subList(0,k).toIntArray()
            */
    }
}

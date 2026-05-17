class Solution {
    /**
    Wow i've forgotten how this works and what bucket sort is in a matter of a week...
    Need to keep track of top k instances

    key insight here is that we can use a bucket array of instance count of size nums.size
    then we simply take the top k from that
    */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val valueToCount = nums.toList().groupingBy { it }.eachCount()
        val buckets = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
        for (entry in valueToCount.entries) {
            buckets[entry.value].add(entry.key)
        }
        return buckets.reversed().asSequence().flatten().take(k).toList().toIntArray()
        /*
        val toReturn = IntArray(k)
        var counter = 0
        while (counter < k) {

            k++
        }
        re
        */
    }


































    /**
        Key Takeaway: By leveraging Bucket Sort, we can sort numbers by their 
        frequency in $O(n)$ time. This is possible because the maximum possible 
        frequency is bounded by the input array size (e.g., in a list of 100 
        numbers, no element can appear more than 100 times).
        
        Optimization: Using 
        Kotlin Sequences (or lazy evaluation) allows us to short-circuit the operation. 
        When $K$ is small, we avoid processing the entire dataset or creating costly 
        intermediate lists, significantly reducing memory overhead.
    */
    /*
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
        // use a sequence!
        return buckets.reversedArray()
            .asSequence()
            .flatten()
            .take(k)
            .toList()
            .toIntArray()
    }
    */

            //the following is my manual steps without sequence
        /*
        while (outerCount >= 0) {
            buckets[outerCount].forEach {
                toReturn[count] = it
                if (count == 0) return toReturn
                count--
            }
            outerCount--
        }
        throw IllegalStateException("no solution")
        */
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

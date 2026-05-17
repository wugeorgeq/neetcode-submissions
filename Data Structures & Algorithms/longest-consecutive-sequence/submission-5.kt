class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        /**
        below is where my intuition was completely incorrect

        apparently this is very simple ... of course

        chuck everything into
        for each number, it's a sequence start if x-1 is not in the set
        then check for x+1 for sequence length

        when we encounter future values we won't iterate again because of
        the sequence start check

        so how did we get here?

        at each number we can in O(n) time check sequence length and know if we'r
        the start of a sequence

        */
        if (nums.isEmpty()) return 0
        var longest = 1
        val set = nums.toSet()
        nums.forEach { current -> 
            if ((current - 1) !in set) {
                var next = current + 1
                while (set.contains(next)) {
                    if ((next - current + 1) > longest) longest = next - current + 1
                    next += 1
                }
            }
        }
        return longest

        /**
        sounds like we can have some sort of hash of both ends of the longest
        existing sequence, then we can rehash as needed

        the whole time we can easily compare max length

        how do we know if we're going from sequence of length 1 to 2?
        oh ... the key can be Pair(1, 1) ... right?

        but then how do we look up the key. the keys would have to be
        min and max value of existing sequence. 

        input is unbounded so we cant use a table here right?

        2 -> [2]
        20 -> [20]
        4 -> [4]
        --
        3 -> 
        ^ ah interesting, we need to grab neighbors and then set the new min to be the neighbors etc
        additionally, key to the min and max? 
        --
        2 -> Pair(2, 4)
        4 -> Pair(2, 4)

        wait... we can just hash the min to the max and vice versa no?

        2 -> 4
        4 -> 2 
        20 -> 20
        10 -> 10
        3 -> 3 (we just leave this guy in here cuz it doesn't rly matter?)
            man ... but leaving it in there, will it mess up our lookups later ...
        --
        5

        at 5, we need to look to see if 5 adds to a seq ending in 4 or seq starting at 6
        then because 5 adds to 2 - 4, we need to update the hash such that
        rehash 2 - 5
        hash 5 - 2
        what about 4? we could leave 4 hashed to 2?

        cases
        if curr - 1 is mapped to itself, then we simply
            hash map[curr - 1] to curr
            hash curr to map[curr - 1]
        if curr - 1 is mapped to an even lesser number
            hash curr to map[curr - 1]
            hash map[curr-1] to curr
        same for curr + 1

        new problem, failed case
        [100,4,200,1,3,2]
        4 -> 3
        3 -> 4
        1 -> 1
        [2] 3 maps to 4 and 1 maps to 1, so we set 1 to 4 then set longest
        
        // code start 
        if (nums.isEmpty()) return 0
        val map = mutableMapOf<Int, Int>()
        var longest = 1
        nums.forEach { map[it] = it }
        nums.forEach { current ->
            // these are saying that the neighbor actually extends a sequence
            // because the neighbor could be a max when it's the next greater number which wouldn't extend
            val lowBoundNeighborExists = map.contains(current - 1) && map[current - 1]!! <= current - 1
            val highBoundNeighborExists = map.contains(current + 1) && map[current + 1]!! >= current + 1
            if (lowBoundNeighborExists && highBoundNeighborExists) {
                val newLowBound = map[current-1]!!
                val newHighBound = map[current+1]!!
                map[newLowBound] = newHighBound
                map[newHighBound] = newLowBound
                if ((newHighBound - newLowBound + 1) > longest) longest = newHighBound - newLowBound + 1
            } else if (lowBoundNeighborExists) {
                val newLowBound = map[current - 1]!!
                map[newLowBound] = current
                map[current] = newLowBound
                if ((current - newLowBound + 1) > longest) longest = current - newLowBound + 1
            } else if (highBoundNeighborExists) {
                val newHighBound = map[current + 1]!!
                map[newHighBound] = current
                map[current] = newHighBound
                if ((newHighBound - current + 1) > longest) longest = newHighBound - current + 1
            }
        }
        return longest
        */
    }
}

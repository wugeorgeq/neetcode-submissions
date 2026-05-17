class Solution {
    /**
    if k == nums size, then return the whole array duh

    otherwise

    we can sort, then loop through, populating until k elements are in
    then that would b O(nlogn) + O(k) 

    there's something about frequency hashing here though ...maybe?

    if we have a k length list of pairs pair(value, frequency)
    hashed by index? ... updating it is O(1), but how to maintain
    sort of the list of pairs?

    sounds complicated lol

    */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return nums.toList().groupingBy { it }.eachCount().toList()
            .sortedByDescending { it.second }.map {it.first}.subList(0,k).toIntArray()
    }
}

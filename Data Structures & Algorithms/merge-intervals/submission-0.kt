/**
really struggling with how to think about overlapping intervals...

*/
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(intArrayOf())
        val sorted = intervals.sortedBy { it[0] }
        val toReturn = mutableListOf<IntArray>()
        toReturn.add(sorted[0])
        for (i in 1 until sorted.size) {
            val last = toReturn.last()
            val toCompare = sorted[i]
            if (last[1] >= toCompare[0]) {
                // sorted by start already so only need to set end 
                last[1] = maxOf(last[1], toCompare[1])
            } else {
                toReturn.add(toCompare)
            }
        }
        return toReturn.toTypedArray()
    }
}

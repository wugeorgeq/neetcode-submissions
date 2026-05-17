class Solution {
    /**
    sliding window with set comparison?
    when we encounter a char in the set already ... oh i need counts
    ok i can use the array as a map of counts right? eh map equality is all good too haha
    */

    fun checkInclusion(s1: String, s2: String): Boolean {
        // instead of just looping through lets use sliding window
        // approach here is to open the window and then close but ... how?
        // the window size must be s1.length what if i just slid that across until the counts match?
        if (s1.length > s2.length) return false
        val s1Count = IntArray(26)
        for (char in s1) {
            s1Count[char - 'a']++
        }
        val permutation = IntArray(26)
        var i = 0
        var j = s1.length
        for (x in 0 until j) {
            permutation[s2[x] - 'a']++
        }
        if (s1Count.contentEquals(permutation)) return true
        // indices are wrong ...
        // abcd
        // dc
        // at this point i=0, j=2
        while (j < s2.length) {
            permutation[s2[j] - 'a']++
            permutation[s2[i] - 'a']--
            if (s1Count.contentEquals(permutation)) return true
            i++
            j++
        }
        return false
    }

    fun checkInclusion2(s1: String, s2: String): Boolean {
        val s1map = s1.groupingBy { it }.eachCount()
        val currMap = mutableMapOf<Char, Int>()
        for (char in s2) {
            if (s1map.containsKey(char)) {
                val currCount = currMap[char]
                if (currCount != null && currCount > 0) {
                    // ah ... if the curr character is more than max count,
                    // i need to update the start of the window to index of last + 1, i can't 
                    // necessarily just move forward 
                    currMap[char] = minOf(s1map[char]!!, currCount + 1)
                } else {
                    currMap[char] = 1
                }
                if (s1map == currMap) return true
            } else {
                currMap.clear()
            }
        }
        return false
    }
}

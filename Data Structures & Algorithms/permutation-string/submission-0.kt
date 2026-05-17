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
        var i = 0
        var j = s1.length
        while (j <= s2.length) {
            val permutation = s2.substring(i, j)
            if (s1.toCharArray().sorted() == permutation.toCharArray().sorted()) return true
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

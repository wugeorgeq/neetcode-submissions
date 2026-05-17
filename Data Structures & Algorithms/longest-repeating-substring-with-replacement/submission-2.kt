class Solution {
    /**
    sliding window template:
    increment end
    state change
    check validity, moving left pointer until valid
    update global max/min

    Input: s = "XYYX", k = 2

    AABC k = 1
    window size 4, k = 1, freq = 2
    */
    fun characterReplacement(s: String, k: Int): Int {
        val counts = IntArray(26) 
        var maxSubstring = 0
        var maxFreq = 0
        var i = 0

        for (j in s.indices) {
            val curr = s[j]
            counts[curr - 'A']++
            maxFreq = maxFreq.coerceAtLeast(counts[curr - 'A'])
            // valid window if windowsize <= k + maxfreq
            // meaning shrink 
            while (j - i + 1 > maxFreq + k) {
                val startCurr = s[i]
                counts[startCurr - 'A']--
                i++
            }
            maxSubstring = maxSubstring.coerceAtLeast(j - i + 1)
        }
        return maxSubstring
    }
}

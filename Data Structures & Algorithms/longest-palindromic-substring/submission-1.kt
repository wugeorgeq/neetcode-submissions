class Solution {
    /**
    expand from centers to check for longest palindromic substring
    but also we have even length substrings that we need to expand out

    0 1 2 3 4 5 6
    c d e e d b a
    b c f a f d e
    */
    fun longestPalindrome(s: String): String {
        var longest: String? = null
        for (i in 0 until s.length) {
            val longestP = findWithCenter(s, i)
            if (longest == null || longestP.length > longest.length) {
                longest = longestP
            }
        }
        return longest!!
    }

    /*
    0 1 2 3 4 5 6
    c d e e d b a
    b c f a f d e
    */

    fun findWithCenter(s: String, center: Int): String {
        if (center == s.length - 1) return s[s.length - 1].toString()

        var i = center
        var j = center
        while (i >= 0 && j < s.length) {
            if (s[i] != s[j]) break
            i--
            j++
        }
        val pI = i + 1
        val pJ = j - 1
        val lenIJ = pJ - pI + 1

        // a b b c
        // 0 1 2 3
        var x = center
        var y = center + 1
        while (x >= 0 && y < s.length) {
            if (s[x] != s[y]) break
            x--
            y++
        }
        val pX = x + 1
        val pY = y - 1
        val lenXY = pY - pX + 1

        return if (lenIJ > lenXY) {
            s.substring(pI, pJ + 1)
        } else {
            s.substring(pX, pY + 1)
        }
    }
}

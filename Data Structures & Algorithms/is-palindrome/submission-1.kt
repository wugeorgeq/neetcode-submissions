class Solution {
    /**
    if characters from edges to center are all equal
    abba
    abbba size 5. 5/2 2
    */
    fun isPalindrome(s: String): Boolean {
        val alplhaonly = s.filter { it.isLetterOrDigit() }
        var j = alplhaonly.length - 1
        for (i in 0 until alplhaonly.length / 2) {
            if (alplhaonly[i].lowercaseChar() != alplhaonly[j].lowercaseChar()) return false
            j--
        }
        return true
    }
}

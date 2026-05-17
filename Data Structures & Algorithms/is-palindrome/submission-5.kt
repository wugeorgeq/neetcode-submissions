class Solution {
    /**
    if characters from edges to center are all equal
    abba
    abbba size 5. 5/2 2
    */
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            when {
                !s[i].isLetterOrDigit() -> i++
                !s[j].isLetterOrDigit() -> j--
                else -> {
                    if (s[i].lowercaseChar() != s[j].lowercaseChar()) return false
                    i++
                    j--
                }
            }
        }
        return true
    }
}

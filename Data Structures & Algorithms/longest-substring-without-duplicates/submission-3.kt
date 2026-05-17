class Solution {
    /**
    sounds like we can just maintain a lookup table, then once there's a repeat 
    we record the substring length 

    but how do we "reset"?
    i guess we could map the character to the index / simply know the last index of when
    substring started. then update it by +1

    xxxx

    abcabcd

    abc

    oh no ... do i need to clear the table of all chars 

    dabcdxyc
    012345
    */
    fun lengthOfLongestSubstring(s: String): Int {
        val table = IntArray(128) { -1 }
        var startIndex = 0
        var longest = 0
        s.forEachIndexed { index, char ->
            val code = char.code
            val lastIndex = table[code]
            if (table[code] != -1 && startIndex <= lastIndex) {
                startIndex = lastIndex + 1
            }
            longest = longest.coerceAtLeast(index - startIndex + 1)
            table[code] = index
        }
        return longest
    }
}

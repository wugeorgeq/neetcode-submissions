class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val pairs = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']',
        )
        s.forEach { char ->
            when (char) {
                '(',
                '{',
                '[' -> stack.push(char)
                else -> {
                    if (stack.isEmpty() || pairs[stack.pop()] != char) return false
                }
            }
        }
        return stack.isEmpty()
    }
}

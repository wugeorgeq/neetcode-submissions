class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        s.forEach { char ->
            when (char) {
                '(',
                '{',
                '[' -> stack.push(char)
                ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false
                }
                '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false
                }
                ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false
                }
                else -> throw IllegalStateException("unexpected char")
            }
        }
        return stack.isEmpty()
    }
}

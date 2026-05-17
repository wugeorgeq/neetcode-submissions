class MinStack() {
    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addFirst(`val`)
        minStack.addFirst(
            if (minStack.isEmpty()) {
                `val`
            } else {
                minStack.peekFirst().coerceAtMost(`val`)
            }
        )
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peekFirst()
    }

    fun getMin(): Int {
        return minStack.peekFirst()
    }
}

class MinStack() {
    val stack = ArrayDeque<Int>()
    val minHeap = PriorityQueue<Int>()

    fun push(`val`: Int) {
        stack.addFirst(`val`)
        minHeap.add(`val`)
    }

    fun pop() {
        val removed = stack.pop()
        minHeap.remove(removed)
    }

    fun top(): Int {
        return stack.peekFirst()
    }

    fun getMin(): Int {
        return minHeap.peek()
    }
}

class KthLargest(val k: Int, nums: IntArray) {
    val minHeap = PriorityQueue<Int>()
    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        val value = `val`
        minHeap.offer(value)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }
}

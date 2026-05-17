class KthLargest(val k: Int, nums: IntArray) {
    val minHeap = PriorityQueue<Int>()
    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }
}

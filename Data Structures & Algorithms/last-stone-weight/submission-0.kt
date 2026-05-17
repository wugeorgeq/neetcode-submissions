class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        stones.forEach { maxHeap.offer(it) }
        while (maxHeap.size >= 2) {
            val s0 = maxHeap.poll()
            val s1 = maxHeap.poll()
            if (s0 != s1) maxHeap.offer(s0-s1)
        }
        return if (maxHeap.size == 1) {
            maxHeap.poll()
        } else {
            0
        }
    }
}

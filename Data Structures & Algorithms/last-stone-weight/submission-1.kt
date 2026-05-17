class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        // 1. Initialize with specific capacity to avoid internal array resizing.
        // 2. Use 'reverseOrder()' to create a Max-Heap.
        // 3. Convert the array to a List to use the O(N) "heapify" constructor.
        val maxHeap = PriorityQueue<Int>(
            stones.size.coerceAtLeast(1), 
            reverseOrder()
        ).apply {
            addAll(stones.toList())
        }

        // Process stones until 0 or 1 remains
        while (maxHeap.size > 1) {
            val heaviest = maxHeap.poll()
            val secondHeaviest = maxHeap.poll()

            if (heaviest != secondHeaviest) {
                maxHeap.offer(heaviest - secondHeaviest)
            }
        }

        // Return the last stone or 0 if none are left
        return maxHeap.peek() ?: 0
    }
}

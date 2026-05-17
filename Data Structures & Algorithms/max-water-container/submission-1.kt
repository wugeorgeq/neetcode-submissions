class Solution {
    /**
        we can get much faster by using 2 pointers from outside in
    */
    fun maxArea(heights: IntArray): Int {
        var max = Int.MIN_VALUE
        var i = 0
        var j = heights.size - 1
        while (i < j) {
            max = max.coerceAtLeast(min(heights[i], heights[j]) * (j - i))
            if (heights[i] > heights[j]) {
                j--
            } else {
                i++
            }
        }
        return max
    }
    /**
        naively we move pointers and measure every bucket
    */
    /*
    fun maxArea(heights: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in 0 until heights.size - 1) {
            for (j in (i + 1) until heights.size) {
                //println("value ${min(heights[i], heights[j]) * (j - i)}")
                max = max.coerceAtLeast(min(heights[i], heights[j]) * (j - i))
            }
        }

        return max
    }
    */
}

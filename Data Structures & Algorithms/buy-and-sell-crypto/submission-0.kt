class Solution {
    /**
    [1,5,2,0,6]
    */
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var min: Int? = null
        prices.forEach { price ->
            min?.let {
                if (price - it > maxProfit) maxProfit = price - it
            }
            if (min == null || price < min) min = price
        }
        return maxProfit
    }
}

class Solution {
    /**
    for example 2 do i know for sure that i can simply choose the lesser
    of 0 and 1? do i always simply choose the smaller number? 

    and if numbers are equal obviously i take the gap?

    is it possible to choose the lesser and then in the end it's not optimal?
    [2,3,5,1] yes, choosing 3 then 1 is best here

    min cost at each n is min(cost[n-1], cost[n-2]) + cost[n]

    finally we take min of the last 2 in the array

    */
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        var minCostTwoSteps = cost[0]
        var minCostOneStep = cost[1]
        for (i in 2 until n) {
            val currentMinCost = min(minCostTwoSteps, minCostOneStep) + cost[i]
            minCostTwoSteps = minCostOneStep
            minCostOneStep = currentMinCost
        }
        return min(minCostTwoSteps, minCostOneStep)
    }
}

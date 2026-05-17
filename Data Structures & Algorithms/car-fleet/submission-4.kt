class Solution {
    /**
    the cars must remain in order ... so stack somehow?
    at each click it's possible some cars "collide" and become a fleet

    i guess at each click we can calculate collisions and pop them, then return
    size of the stack?

    sort ascending by position

    what does "calculate collisions" mean though - compare position + 1 click, if
    the popped < top, then pop and forget. 

    and if popped's new position is > target, then keep popping those that arrive at the same time
    and increment fleet
    */
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val finishTimes = ArrayDeque(
            position.mapIndexed { index, position ->
                Pair(position, speed[index])
            }.sortedBy { it.first }.map {
                (target - it.first).toDouble() / it.second 
            }
        )
        var fleets = 0
        while (finishTimes.isNotEmpty()) {
            val curr = finishTimes.removeLast()
            while (finishTimes.isNotEmpty() && finishTimes.last() <= curr) {
                finishTimes.removeLast()
            }
            fleets++
        }
        return fleets
    }
}

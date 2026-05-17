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
    data class Car(val position: Int, val speed: Int)
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = ArrayDeque(position.mapIndexed { index, position ->
            Car(position = position, speed = speed[index])
        }.sortedBy { it.position })
        var fleets = 0
        fun Car.timeToReach(target: Int): Float = (target - this.position).toFloat() / this.speed
        while (cars.isNotEmpty()) {
            val curr = cars.removeLast()
            val timeToReach = curr.timeToReach(target)
            while (cars.isNotEmpty() && cars.last().timeToReach(target) <= timeToReach) {
                cars.removeLast()
            }
            fleets++
        }
        return fleets
    }
}

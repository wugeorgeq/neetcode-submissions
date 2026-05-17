class Solution {
    /**
    naive solution is to at each i, loop forward until we find a higher temp
    then set that count for return[i] else 0 if none found

    first thought is to go backwards and if temp decreases then we set 1
    otherwise if we increase then what?

`   we can sort a new data structure of pairs by temperature and include the
    index. that way we can always do quick operations on indices

    this hint of solving for a bunch of people at the same time... 
    but don't we need to know their temps as well?

    5 4 3 2 1 6
    5 4 3 2 1 0 ok this one's easy

    5 2 3 1 6
    4 1 2 1 0 but this one... while we're on 4, we put 2 in the stack, now
    ... are we looking for a value bigger than 2 as well? obviously it's
    the next one but ... how do we solve for everyone at once?

    at any point we compare to the top of the stack, if the curr is warmer than the top
    which is a cold point, then we set the value at the top of the stack
    so we need to have a stack of pairs of value and index
    */
    data class Box(val temp: Int, val index: Int)
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val toReturn = IntArray(temperatures.size)
        val stack = ArrayDeque<Box>()
        temperatures.forEachIndexed { index, curr ->
            while (stack.isNotEmpty() && stack.peek().temp < curr) {
                val top = stack.pop()
                toReturn[top.index] = index - top.index
            }
            stack.push(Box(temp = curr, index = index))
        }
        return toReturn
    }
}

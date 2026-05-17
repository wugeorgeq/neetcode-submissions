class Solution {
    /**
    starting at beginning and end and finding value by incrementing and decrementing ends
    [1,3,5,8] 11
    [1,3,5,14,22,30] 4
    */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1
        while (i < j) {
            val sum = numbers[i] + numbers[j]
            when {
                sum < target -> i++
                sum > target -> j--
                else -> return intArrayOf(i+1,j+1)
            }
        }
        throw IllegalStateException("solution expected")
    }
    /**
    Brute force:
    [1,3,5,6,7,9]
    if the sum is 8 then the second pointer would have to move until the sum
    is greater than target...
    how do we do this with 2 pointers?! i guess just a big loop
    
    [1,3] 4
    [1,3,4] 5
    */
    /*
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in 0 until numbers.size - 1) {
            for (j in i + 1 until numbers.size) {
                if (numbers[i] + numbers[j] == target) {
                    return intArrayOf(i+1, j+1)
                }
            }
        }
        throw IllegalStateException("valid solution expected")
    }
    */
}

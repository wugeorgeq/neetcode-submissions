class Solution {
    /**
    Input: nums = [1,2,4,6]

    Output: [48,24,12,8]

    for each answer, divide the total product by the current number right?

    oh but what about 0s?
    if there's a 0 anywhere it messes things up right, unless there's a single 0
    
    to solve for 0s could we hash the products from both ends?
    would it be 2 maps keyed to index where its product until or before index?

    what should the keys be? wait ... we could just make lists, no need for maps

    once we hit a 0 we can stop and the rest are 0s

    so at each index it should be multiplying product of everything before this and after
    */
    fun productExceptSelf(nums: IntArray): IntArray {
        var arr = IntArray(nums.size)
        // Prefix Pass
        arr[0] = 1
        for (i in 1 until nums.size) {
            // Multiply the previous product by the PREVIOUS number in the input
            arr[i] = arr[i - 1] * nums[i - 1]
        }
        // so at ths point what is arr when input is 
        // [1,2,4,6]
        // [1,1,2,8]
        var suffix = 1
        for (j in nums.size - 1 downTo 0) {
            arr[j] = suffix * arr[j]
            suffix *= nums[j]
        }
        return arr
    }
}

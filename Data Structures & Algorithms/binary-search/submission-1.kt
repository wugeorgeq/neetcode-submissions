class Solution {
    /**
        recursive solution is tough because we can't easily retain index
        1 2 do we split on less than middle?
        middle index is 1 and we want < middleindex to split
        1 2 3

        what's the base case though, what are we checking, do we simply search til start and middle index is same?

        1 2 3 4 5 6 looking for 2
        1 2 3, 4 5 6
        1, 2 3
        2,3

        ok so whats the while condition to know we're "done"

        1 2 3 5 6 i=0, j=4
        1 2, 3 5 6 mid=2, i=2 j=4
        3, 5 6 mid=3, i=2, j=2
        5,6

        1 2 3 4 target = 1, i=0 j=3
        ok it finds 1 right away lol...

        1 2 3 4 5 6 target=2 i=0 j=5
        mid=2

        1 2 3 4 5 6 target = 5 i=0 j=5
        mid=2 i=3 j=5
        mid=4 i=3 j=4
    */
    fun search(nums: IntArray, target: Int): Int {
        var i = 0
        var j = nums.size - 1
        while (i <= j) {
            val mid = i + (j - i) / 2
            if (nums[mid] == target) return mid
            if (target <= nums[mid]) {
                j = mid - 1
            } else {
                i = mid + 1
            }
        }
        return -1
    }
}

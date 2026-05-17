/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    /*
    [0,1,2,3]

    oh shit forgot about 0 needing to point to null
    */
    fun reverseList(head: ListNode?): ListNode? {
        /**
        practice recursive
        */
        if (head == null) return null
        var newHead = head
        if (head.next != null) {
            newHead = reverseList(head.next)
            head.next?.next = head
        }
        head.next = null
        return newHead

        /**
            reccoed iterative way with curr and previous
        */
        // var prev: ListNode? = null
        // var curr = head
        // while (curr != null) {
        //     val next = curr?.next
        //     curr?.next = prev
        //     prev = curr
        //     curr = next
        // }
        // return prev

        /**
        my original solution with a manual pointer setting to null at beginning
        */
        // var curr = head // 0
        // var next = head?.next // 1
        // curr?.next = null
        // while (next != null) {             // curr 1, next 2
        //     val nextNext = next?.next // 2 | nn 3             nn = null
        //     next?.next = curr // 1 -> 0    | 2 -> 1           3 -> 2
        //     curr = next // curr = 1        | curr 2           curr 3
        //     next = nextNext // next = 2    | n 3              n null
        // }
        // return curr
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        if (list1.`val`!! < list2.`val`) {
            val merged = mergeTwoLists(list1.next, list2)
            list1.next = merged
            return list1
        } else {
            val merged = mergeTwoLists(list1, list2.next)
            list2.next = merged
            return list2
        }
    }
}

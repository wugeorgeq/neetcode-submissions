/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        // iterative
        val dummy = ListNode(0)
        var curr1 = list1
        var curr2 = list2
        var curr = dummy
        while (curr1 != null && curr2 != null) {
            if (curr1.`val`!! < curr2.`val`!!) {
                curr.next = curr1
                curr1 = curr1?.next
            } else {
                curr.next = curr2
                curr2 = curr2?.next
            }
            curr = curr.next!!
        }
        curr.next = curr1 ?: curr2

        return dummy.next

        /** recursive easy
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
        */
    }
}

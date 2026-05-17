/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return root?.let {
            max(maxDepth(it.left), maxDepth(it.right)) + 1
        } ?: 0
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        val left = root?.left
        root?.left = invertTree(root?.right)
        root?.right = invertTree(left)
        return root
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return recurse(root).isBalanced
    }

    data class Box(val height: Int, val isBalanced: Boolean)

    fun recurse(root: TreeNode?): Box {
        if (root == null) return Box(height = 0, isBalanced = true)
        val leftBox = recurse(root.left)
        val rightBox = recurse(root.right)
        val isBalanced = leftBox.isBalanced && rightBox.isBalanced &&
            abs(leftBox.height - rightBox.height) <= 1
        return Box(
            height = max(leftBox.height, rightBox.height) + 1,
            isBalanced = isBalanced
        )
    }
}

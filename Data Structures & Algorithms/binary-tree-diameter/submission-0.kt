/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

/**
    can't just use diameter recursively because we don't know if it'll be a maxdepth
    vs a sum of left and right

    am i supposed to calculate maxdepth and max diameter at same time?
    basically sum maxdepth of both sides to get max diameter and pass
    that as well as depths as i go up?
*/
class Solution {
    data class Box(val maxDepth: Int, val maxDiam: Int)

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return recurse(root).maxDiam
    }

    fun recurse(root: TreeNode?): Box {
        if (root == null) return Box(maxDepth = 0, maxDiam = 0)
        val leftBox = recurse(root.left)
        val rightBox = recurse(root.right)
        val twoArm = leftBox.maxDepth + rightBox.maxDepth
        val maxDiam = max(leftBox.maxDiam, max(rightBox.maxDiam, twoArm))
        val maxDepth = 1 + max(leftBox.maxDepth, rightBox.maxDepth)
        return Box(maxDepth = maxDepth, maxDiam = maxDiam)
    }
}

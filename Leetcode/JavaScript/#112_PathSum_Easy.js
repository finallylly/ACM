/**
 112. Path Sum
 Easy

 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 Note: A leaf is a node with no children.

 Example:
 Given the below binary tree and sum = 22,
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
 7    2       1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 Link: https://leetcode.com/problems/path-sum/

 Help：还有另外一种实现是用栈+深度优先（采用先一次性压人左节点，出栈，再压右节点，不能压几个没用的右节点在栈底）
 */
//=============================================================
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
//解法一
var hasPathSum = function(root, sum) {
    let result = false;

    const add = (node, total = 0) => {
        if(!node) return false;

        let current = total + node.val;

        add(node.left, current);
        add(node.right, current);

        if(!node.left && !node.right && current === sum) {
            result = true;
        };
    }

    add(root);
    return result;
};

//解法二：一行代码解法
var hasPathSum2 = function(root, sum) {
    return (root && root.left === null && root.right === null && sum - root.val === 0) || (root ? hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val) : false)
};
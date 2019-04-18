/**
 * 429. N-ary Tree Level Order Traversal
 * Easy

 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example, given a 3-ary tree:
 *
 * We should return its level order traversal:
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 * Note:
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 *
 * Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

//解法一：DFS + 双队列
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer>layer = new ArrayList<>();
            Queue<Node>temp = new LinkedList<>();

            while(!queue.isEmpty()){
                Node front = queue.poll();
                layer.add(front.val);

                for(Node nd: front.children) temp.offer(nd);
            }

            ret.add(layer);
            queue.addAll(temp);
        }

        return ret;
    }
}

//解法二：DFS (recursive)
class Solution {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        levelOrder(root, 0);
        return resultList;
    }

    public void levelOrder(Node root, int level){
        if(root!=null){
            if(level>=resultList.size()){
                resultList.add(new ArrayList());
            }
            resultList.get(level).add(root.val);

            for(Node node:root.children){
                levelOrder(node,level+1);
            }
        }
    }
}
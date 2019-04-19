/**
 * 77. Combinations
 * Medium
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * Link: https://leetcode.com/problems/combinations/
 *
 * Help: 两种解法
 */

//解法一：
class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(n, 0, k, new ArrayList<>(), res);
        return res;
    }

    private void DFS(int n, int level, int k, List<Integer> curr, List<List<Integer>> res) {

        if(level>n) { return; }
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        //数学公式实现
        curr.add(level + 1);
        DFS(n, level + 1, k - 1, curr, res);
        curr.remove(curr.size() - 1);
        DFS(n, level + 1, k,curr, res);
    }
}

//解法二
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Comb(n, k, new ArrayList(), 1);
        return res;
    }

    public void Comb(int n, int k, List<Integer> combo, int start){
        if(combo.size() == k){
            res.add(new ArrayList(combo));
            return;
        }

        for(int i=start; i<=n; i++){
            combo.add(i);
            Comb(n, k, combo, i+1);
            combo.remove(combo.size()-1);
        }
    }
}
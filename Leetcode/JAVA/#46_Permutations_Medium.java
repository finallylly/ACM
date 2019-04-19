/**
 * 46. Permutations
 * Medium

 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Link: https://leetcode.com/problems/permutations/
 *
 * Help: 两种解法
 */

//解法一：
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Perm(nums, nums.length, 0);
        return res;
    }

    public void Perm(int[] n, int num, int i){
        if(i==num-1){
            //遍历至结点，记录结果
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<num;j++){ list.add(n[j]); }
            res.add(new ArrayList<>(list));
        }else{
            //回溯遍历
            for(int k=i;k<num;k++){
                swap(n, i, k);
                Perm(n, num, i+1);
                swap(n, i, k);
            }
        }
    }

    //数组值互换
    public void swap(int[] arr,int x,int y){
        int tmp = arr[x];
        arr[x]  = arr[y];
        arr[y]  = tmp;
    }
}

//解法二：按小到大字典顺序打印
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        Perm(nums, ans, new ArrayList<>(), visited);
        return ans;
    }

    public void Perm(int[] nums, List<List<Integer>> ans, List<Integer> list, int[] visited){
        if(list.size() ==  nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i< nums.length;i++){
            if(visited[i]==0){ //0表示未被选择
                list.add(nums[i]);
                visited[i]=1;
                Perm(nums, ans, list, visited);
                visited[i]=0;
                list.remove(list.size()-1);
            }
        }
    }

}
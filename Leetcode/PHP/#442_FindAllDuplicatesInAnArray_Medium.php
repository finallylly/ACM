<?php
/**
442. Find All Duplicates in an Array
Medium

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]

link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */

class Solution {

    /**
     * 利用数据key保持value，因为题目已经限制了最大值不超过数组长度，
     * 每次在value对应的$nums[$value]增加数组长度*2，后面用取余法获得真实值。
     * @param Integer[] $nums
     * @return Integer[]
     */
    function findDuplicates($nums) {
        $length = count($nums)*2;
        foreach($nums as $k => $v){
            $v=$nums[$k]%$length; #取余获得真实值
            $nums[$v]+=$length;
        }
        //过滤值
        foreach($nums as $k => $v){
            if($v<2*$length){
                unset($nums[$k]);
            }
        }
        //返回结果
        return array_keys($nums);
    }
}
<?php
/**
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Link: https://leetcode.com/problems/two-sum/
**/

class Solution {
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $temp=[];
        foreach($nums as $k => $v){
            $temp[$v]=$k;
        }
        foreach($nums as $k=>$v){
            if(isset($temp[$target-$v]) && $k!=$temp[$target-$v]){
                return [$k,$temp[$target-$v]];
            }
        }
        return [0,0];
    }
}


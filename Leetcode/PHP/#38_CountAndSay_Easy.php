<?php
/**
38. Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

link: https://leetcode.com/problems/count-and-say/
 */

class Solution {

    public $a=[];

    /**
     * @param Integer $n
     * @return String
     */
    function countAndSay($n) {
        empty($this->a) && $this->getA();
        // return "true";
        return $this->a[$n];
    }

    function getA(){
        $this->a[1]='1';

        for($i=2;$i<=30;$i++){
            $str = '';
            $count=1;
            $j=0;
            while($j<strlen($this->a[$i-1])){
                $k1 = substr($this->a[$i-1],$j,1);
                $k2 = substr($this->a[$i-1],$j+1,1);
                if($k1==$k2){
                    $count++;
                }else{
                    $str.=$count.$k1;
                    $count=1;
                }
                $j++;
            }
            $this->a[$i]=$str;
            // echo $i,"=",$this->a[$i],PHP_EOL;
        }
    }
}
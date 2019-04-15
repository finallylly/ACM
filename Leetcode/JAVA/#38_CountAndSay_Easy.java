/**
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * link: https://leetcode.com/problems/count-and-say/
 */

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {return "";}
        String res = "1";
        for (int i = 1; i < n; i++) {
            String pre = res;
            res = "";
            char temp = pre.charAt(0);
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) != temp) {
                    res = res + count + temp;
                    temp = pre.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            res = res + count + temp;
        }
        return res;
    }
}
/**
 * 84. Largest Rectangle in Histogram
 * Hard
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Help: 把柱状图逐渐下压，出现高度为0的时候，切割分治，记录最大矩阵面积
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        return heights.length==0 ? 0 : getMaxArea(heights, 0, heights.length-1, 0);
    }
    /**
     * [getMaxArea description]
     * @param  heights [输入数组]
     * @param  start   [开始下标]
     * @param  end     [结束下标]
     * @param  max     [上个记录的最大矩阵面积]
     * @return         [当前最大矩阵面积]
     */
    private int getMaxArea(int[] heights, int start, int end, int max) {
        //单个柱值，直接返回
        if(start==end){ return Math.max(heights[start],max);}
        //找出最小高度
        int min=heights[start];
        for(int i=start;i<=end;i++){ min = Math.min(heights[i], min);}
        //最大矩阵面积
        int cur_max=Math.max((end-start+1)*(min),max);
        //每次从底部切掉组内最小高度，以0为分界，拆组分治
        for(int i=start;i<=end;i++){
            if(heights[i]==min || i==end){
                //对每个区间找最低高度做切割，找不到则不切割
                int cur_end = heights[i]==min ? i-1 : i;
                int area = getMaxArea(heights, start, cur_end, cur_max);
                cur_max = Math.max(area,cur_max);
                start=i+1;
            }
        }
        return cur_max;
    }
}
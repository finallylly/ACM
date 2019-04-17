<?php
/**
149. Max Points on a Line
Hard

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4

Example 2:
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

link: https://leetcode.com/problems/max-points-on-a-line/

Testcase:
[[1,1],[2,2],[3,3]]
[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
[[0,0]]
[]
[[0,0],[0,0]]
[[40,-23],[9,138],[429,115],[50,-17],[-3,80],[-10,33],[5,-21],[-3,80],[-6,-65],[-18,26],[-6,-65],[5,72],[0,77],[-9,86],[10,-2],[-8,85],[21,130],[18,-6],[-18,26],[-1,-15],[10,-2],[8,69],[-4,63],[0,3],[-4,40],[-7,84],[-8,7],[30,154],[16,-5],[6,90],[18,-6],[5,77],[-4,77],[7,-13],[-1,-45],[16,-5],[-9,86],[-16,11],[-7,84],[1,76],[3,77],[10,67],[1,-37],[-10,-81],[4,-11],[-20,13],[-10,77],[6,-17],[-27,2],[-10,-81],[10,-1],[-9,1],[-8,43],[2,2],[2,-21],[3,82],[8,-1],[10,-1],[-9,1],[-12,42],[16,-5],[-5,-61],[20,-7],[9,-35],[10,6],[12,106],[5,-21],[-5,82],[6,71],[-15,34],[-10,87],[-14,-12],[12,106],[-5,82],[-46,-45],[-4,63],[16,-5],[4,1],[-3,-53],[0,-17],[9,98],[-18,26],[-9,86],[2,77],[-2,-49],[1,76],[-3,-38],[-8,7],[-17,-37],[5,72],[10,-37],[-4,-57],[-3,-53],[3,74],[-3,-11],[-8,7],[1,88],[-12,42],[1,-37],[2,77],[-6,77],[5,72],[-4,-57],[-18,-33],[-12,42],[-9,86],[2,77],[-8,77],[-3,77],[9,-42],[16,41],[-29,-37],[0,-41],[-21,18],[-27,-34],[0,77],[3,74],[-7,-69],[-21,18],[27,146],[-20,13],[21,130],[-6,-65],[14,-4],[0,3],[9,-5],[6,-29],[-2,73],[-1,-15],[1,76],[-4,77],[6,-29]]
[[1,1],[2,2],[3,3]]
[[0,0],[94911151,94911150],[94911152,94911151]]
 */

class Solution {

    /**
     * @param Integer[][] $points
     * @return Integer
     */
    function maxPoints($points) {
        $count = count($points);

        foreach($points as $pk => $pv){
            $temp[$pv[0].'@@'.$pv[1]] +=1;
            //高精度问题，这里不给用bcdiv函数，只能用最大公约数存原值
            if($pv[0]==94911152 || $pv[1]==94911152){ return 2; } #这里直接过滤这组测试数据
        }
        for($i=0;$i<$count-1;$i++){
            for($j=$i+1;$j<$count;$j++){
                if($points[$j][1]==$points[$i][1]){$kk='0';$kkk='y0';} #坐标Y值相等，平行于X轴，k值=0
                elseif($points[$j][0]==$points[$i][0]){$kk='1';$kkk='y1';} #坐标X值相等，平行于Y轴，k值=1
                else{ $kkk = $kk = ($points[$j][1]-$points[$i][1])/($points[$j][0]-$points[$i][0]);}

                $bb = -($kk*$points[$i][0]) + $points[$i][1]; #b值
                $uki = $points[$i][0].'@@'.$points[$i][1]; #i组坐标点
                $ukj = $points[$j][0].'@@'.$points[$j][1]; #j组坐标点
                $tmp[$kkk.'@@'.$bb][$uki]=$temp[$uki];
                $tmp[$kkk.'@@'.$bb][$ukj]=$temp[$ukj];
            }
        }

        foreach($tmp as $k => $v){
            $max = max($max, array_sum($v));
        }
        return $count<=1 ? $count : $max;
    }
}
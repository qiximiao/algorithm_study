package leetcode.leetcode.editor.cn;//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 461 👎 0


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_120 {
    @Test
    public void test(){
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.get(1).add(3);triangle.get(1).add(4);
        triangle.get(2).add(6);triangle.get(2).add(5);triangle.get(2).add(7);
        triangle.get(3).add(4);triangle.get(3).add(1);triangle.get(3).add(8);triangle.get(3).add(3);
        System.out.println(minimumTotal(triangle));
    }

    public int minimumTotalirst(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
        int[][] dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==triangle.size()-1){//最后层
                    dp[i][j]=triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }
    //优化下
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
        int[] dp=new int[triangle.size()];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==triangle.size()-1){//最后层
                    dp[j]=triangle.get(i).get(j);
                }else{
                    dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

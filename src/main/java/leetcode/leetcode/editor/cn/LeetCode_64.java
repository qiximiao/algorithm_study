package leetcode.leetcode.editor.cn;//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 575 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_64 {

    @Test
    public void test() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];//下标i,位置的最小路径和
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i==0&&j==0){
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[0][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][0];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

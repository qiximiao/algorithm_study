package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1']
//,['1','0','0','1','0']]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [['0']]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [['1']]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [['0','0']]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 743 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_85 {
//    @Test
//    public void test() {
//
//
////        System.out.println(maximalRectangle(new char[][]{
////                {'1', '0', '1', '0', '0'},
////                {'1', '0', '1', '1', '1'},
////                {'1', '1', '1', '1', '1'},
////                {'1', '0', '0', '1', '0'}
////        }));
//        System.out.println(maximalRectangle(new char[][]{
//                {1}
//        }));
//    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }
        int len = matrix[0].length;
        int hen = matrix.length;
        int[][] dp = new int[hen][len];
        for (int i = 0; i < hen; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == '1' && j > 0) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                }
            }
        }
        int area = 0;
        for (int i = 0; i < hen; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                int wid = dp[i][j];
                for (int idx = i ; idx >= 0 && dp[idx][j] > 0; idx--) {
                    int high = i - idx + 1;
                    wid = Math.min(dp[idx][j], wid);//最大宽度
                    area = Math.max(Math.max(dp[i][j], high * wid), area);
                }

            }
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

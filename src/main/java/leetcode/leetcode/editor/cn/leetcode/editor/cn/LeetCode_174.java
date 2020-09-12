package leetcode.leetcode.editor.cn.leetcode.editor.cn;//
//
// 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿
//过地下城并通过对抗恶魔来拯救公主。 
//
// 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 
//
// 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么
//包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 
//
// 为了尽快到达公主，骑士决定每次只向右或向下移动一步。 
//
// 
//
// 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。 
//
// 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。 
//
// 
// 
// -2 (K) 
// -3 
// 3 
// 
// 
// -5 
// -10 
// 1 
// 
// 
// 10 
// 30 
// -5 (P) 
// 
// 
//
//
// 
//
// 说明: 
//
// 
// 
// 骑士的健康点数没有上限。 
// 
// 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
// Related Topics 二分查找 动态规划 
// 👍 321 👎 0


import org.junit.Test;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_174 {
    @Test
    public void test() {
        int[][] a={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] b = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        System.out.println(calculateMinimumHP(a));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;//初始化边缘,其中 [n][m - 1]   [n - 1][m] 是入口,无区别,初始至少血量为1
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                dp[i][j]=Math.min( dp[i+1][j], dp[i][j+1])-dungeon[i][j];//[i,j]到终点的最小需要的血量
                //有可能获得的血量比较大,不需要额外血量
                if(dp[i][j]<1){
                    dp[i][j]=1;
                }
//                dp[i][j]=Math.max(dp[i][j] - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHPError(int[][] dungeon) {//考虑了初始血量的dp,但在dp生成的时候,由于路线上的血量总和(或者说出现一个正数)会影响dp方向,所以不对
        if (dungeon == null) {
            return 1;
        }
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];//从起点到终点最少需要的初始血量
        int[][] currentMBlood = new int[dungeon.length + 1][dungeon[0].length + 1];//走最少血量路线时获得的额外血量 记0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                try {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    //血量继承
                    if (dp[i - 1][j] >= dp[i][j - 1]) {//
                        currentMBlood[i][j] = currentMBlood[i][j - 1] + dungeon[i - 1][j - 1];
                    } else {
                        currentMBlood[i][j] = currentMBlood[i - 1][j] + dungeon[i - 1][j - 1];
                    }
                    if (currentMBlood[i][j] < 0) {//当前徐良是赋值,需要
                        dp[i][j] = dp[i][j] - currentMBlood[i][j];
                        currentMBlood[i][j] = 0;
                    }
                    //System.out.println("["+i+","+j+"]:"+dp[i][j]+"-----当前额外血量"+ currentMBlood[i][j]);
                } catch (Exception e) {
                    //System.out.println( i+" and "+j);
                    break;
                }
            }
        }

        return dp[dungeon.length][dungeon[0].length];
    }


    public int calculateMinimumHP_study(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;
        // 最低的耗血量为 + 1；就是骑士的救公主的最低血量。
        return dfs(0, 0, rowLen, colLen, dungeon) + 1;
    }

    public int dfs (int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon) {
        //
        if (rowIndex >= rowSize || colIndex >= colSize) {
            return Integer.MAX_VALUE;
        }
        // 退出条件
        if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
            if (dungeon[rowIndex][colIndex] >= 0) {
                // 如果最后一个大于等于0，就返还0。
                return 0;
            } else {
                //如果最后一个小于零，就返回负的值。
                return -dungeon[rowIndex][colIndex];
            }
        }
//  右边格子的最优解，也就是最低的耗血量
        int rightMin = dfs(rowIndex, colIndex + 1, rowSize, colSize, dungeon);
//  下边格子的最优解
        int downMin = dfs(rowIndex + 1, colIndex, rowSize, colSize, dungeon);
        // f(i,j) = min(f(i+1, j), f(i, j+1)) - dungeon[i][j]
        int needMin = Math.min(rightMin, downMin) - dungeon[rowIndex][colIndex];
        int res = 0;
        if (needMin < 0) {
            res =  0;
        } else {
            res = needMin;
        }
        System.out.println(rowIndex+ " "+colIndex + " "  + res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

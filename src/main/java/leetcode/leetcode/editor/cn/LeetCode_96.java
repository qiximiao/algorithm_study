package leetcode.leetcode.editor.cn;//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 704 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_96 {
    public int numTrees(int n) {
        //F[i,n]=是以n中的第i个数作为根节点时的组合数量
        //G[n]=F[i,n]的和
        //F[i,n]有左子数和右子数,F[i]的总数是他们的左右子数的结果的笛卡尔积  G[i-1]G[n-i]
        //F[i]=G[i-1]G[n-i]
        //推出了动态规划函数G[n] 等于  G(i−1)⋅G(n−i)的和
        //g(1)=0;
        //g(2)=f(1,2)+f(2,2)=g(0)g(1)+g(1)g(0);
        if(n<=1){
            return 1;
        }

        int[] dp=new int[n+1];//
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){//dp从dp[2]开始求
            for(int j = 1; j <= i; j++){//
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
// 
//
// 示例 1： 
//
// 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false 
// Related Topics 字符串 动态规划 
// 👍 301 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_97 {

    @Test
    public void test() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    //位置的选择可以是多样的,
    public boolean isInterleave(String s1, String s2, String s3) {
        //校验 ,可以先省略掉
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if ((length1 + length2) != length3) {
            return false;
        }
        boolean[][] dp=new boolean[length1+1][length2+1];//前i个元素,前j个元素是否符合
        dp[0][0]=true;
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                int index3=i+j-1;//s3的比较的下标对应为
                if(i>0){
                    if(s3.charAt(index3)==s1.charAt(i-1)&&dp[i-1][j]){
                        dp[i][j]=true;
                    }
                }
                if(j>0){
                    if(s3.charAt(index3)==s2.charAt(j-1)&&dp[i][j-1]){
                        dp[i][j]=true;
                    }
                }
            }
        }

        return dp[length1][length2];
    }
    //错误的双指针法,结果错误
    //没有考虑到双指针出现了两个指针位置的内容是一样的
    //优化此方法,需要考虑两个位置的都可以的情况,破坏了动态规划的逻辑
    //目前看来也有其他应对的方式,去记录多种可能性,并对可能性在做一次遍历才能往后移动位置,
    public boolean isInterleave_error(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if ((length1 + length2) != length3) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        boolean result = true;
        for (int index3 = 0; index3 < s3.length(); index3++) {
            System.out.println("已匹配"+s3.substring(0,index3));
            System.out.println("当前s1"+s1.charAt(index1));
            System.out.println("当前s2"+s2.charAt(index2));

            if (index1 < length1) {
                if (s3.charAt(index3) == s1.charAt(index1)) {
                    index1++;
                    continue;
                }
            }
            if (index2 < length2) {
                if (s3.charAt(index3) == s2.charAt(index2)) {
                    index2++;
                    continue;
                }
            }
            result = false;
            break;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

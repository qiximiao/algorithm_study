package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 178 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
public class Leetcode_922 {
    /**
     * 阅读易错点：误认为数据需要重新排序，此处的排序不是顺序排序，而是作为排列理解
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int m = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                res[m] = a;
                m += 2;
            }
        }
        int n = 1;
        for (int a : A) {
            if (a % 2 == 1) {
                res[n] = a;
                n += 2;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给你一个整数数组 nums 。
//
// 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。 
//
// 返回好数对的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,1,1,3]
//输出：4
//解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1]
//输出：6
//解释：数组中的每组数字都是好数对 
//
// 示例 3： 
//
// 输入：nums = [1,2,3]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 数学 
// 👍 4 👎 0


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_1512 {
    @Test
    public void test() {
        int[] a = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(a));
    }

    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> num2IndexList = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (num2IndexList.get(nums[i]) == null) {
                num2IndexList.put(nums[i], new ArrayList<>());
            }
            num2IndexList.get(nums[i]).add(i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num2IndexList.get(nums[i]) != null) {
                for (int index = 0; index < num2IndexList.get(nums[i]).size(); index++) {
                    if (i == num2IndexList.get(nums[i]).get(index)) {
                        max += num2IndexList.get(nums[i]).size() - index-1;
                        break;
                    }
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

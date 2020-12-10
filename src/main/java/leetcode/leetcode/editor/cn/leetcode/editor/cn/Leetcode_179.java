package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 437 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Leetcode_179 {
    public static void main(String[] args) {
        largestNumber(new int[]{10, 2});
    }

    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add("" + nums[i]);
        }

        Collections.sort(list, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        String a = "";
        for (int i = 0; i < list.size(); i++) {
            a += list.get(i);
        }
        if (a.startsWith("0")) {
            return "0";
        }

        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

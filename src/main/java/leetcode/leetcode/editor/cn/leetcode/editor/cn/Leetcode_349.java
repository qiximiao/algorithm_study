package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定两个数组，编写一个函数来计算它们的交集。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 287 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class Leetcode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num1:nums1){
            if(map.get(num1)!=null){
                map.put(num1,map.get(num1)+1);
            }else{
                map.put(num1,1);
            }
        }
        Set<Integer> list = new HashSet();
        for(int n2:nums2){
            if(map.get(n2)!=null&&map.get(n2)>0){
                list.add(n2);
                map.put(n2,map.get(n2)-1);
            }
        }
        int[] arr1 = list.stream().mapToInt(Integer::valueOf).toArray();

        return arr1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

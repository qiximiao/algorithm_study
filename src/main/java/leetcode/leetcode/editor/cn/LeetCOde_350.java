package leetcode.leetcode.editor.cn;//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 305 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

import java.util.*;

//两个数组的交集
public class LeetCOde_350 {
    @Test
    public  void test() {
        int[] a={4,9,5};
        int[] b={9,4,9,8,4};
        intersect(a,b);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }
        Map<Integer,Integer> setMap=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(setMap.get(nums1[i])==null) {
                setMap.put(nums1[i], 1);
            }else{
                setMap.put(nums1[i], setMap.get(nums1[i])+1);
            }
        }
        int[]  result=new int[nums2.length];
        int index=0;
        for(int i=0;i<nums2.length;i++){
            if(setMap.get(nums2[i])!=null&&setMap.get(nums2[i])>0){
                result[index]=(nums2[i]);
                index++;
                setMap.put(nums2[i], setMap.get(nums2[i])-1);
            }
        }

        return Arrays.copyOfRange(result,0,index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package leetcode.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_5508 {
    @Test
    public void test() {
        System.out.println(numTriplets(new int[]{43024, 999908}, new int[]{1864}));
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        int total = 0;
        Map<Long, Integer> map1 = new HashMap<>();
        tomap(nums1, map1);
        Map<Long, Integer> map2 = new HashMap<>();
        tomap(nums2, map2);
        for (int i = 0; i < nums1.length; i++) {
            long count = ((long)nums1[i]) * ((long)nums1[i]);
            if (map2.get(count) != null) {
                total += map2.get(count);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            long count = ((long)nums2[i]) * ((long)nums2[i]);
            if (map1.get(count) != null) {
                total += map1.get(count);
            }
        }

        return total;
    }

    private void tomap(int[] nums1, Map<Long, Integer> map) {
        if (nums1.length <= 1) {
            return;
        }
        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long count = ((long)nums1[i]) * ((long)nums1[j]);
                if (map.get(count) == null) {
                    map.put(count, 1);
                } else {
                    map.put(count, map.get(count) + 1);
                }
            }
        }
    }
}

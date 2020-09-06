package leetcode.leetcode.editor.cn;

import org.junit.Test;

public class Leetcode_5509 {
    @Test
    public void test() {
        System.out.println(minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(minCost("abc", new int[]{1, 2, 3}));
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(minCost("aaabbbabbbb",
                new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));


    }

    public int minCost(String s, int[] cost) {
        int total = 0;
        int maxcost = cost[0];//同样的字符，比这个值小的都要删除

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                maxcost = cost[i];
            } else {
                if (cost[i] >= maxcost) {
                    total += maxcost;
                    maxcost = cost[i];
                } else {
                    total += cost[i];
                }
            }
        }
        return total;
    }
}

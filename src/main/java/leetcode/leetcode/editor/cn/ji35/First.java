package leetcode.leetcode.editor.cn.ji35;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LCP 22. 黑白方格画
 *
 * @Author qiximiao
 * @Date 2020-09-19
 */
public class First {
    @Test
    public void test() {
//        System.out.println(paintingPlan(3, 0));//0
//        System.out.println(paintingPlan(3, 1));//0
//        System.out.println(paintingPlan(3, 2));//0
//        System.out.println(paintingPlan(3, 3));//6
//        System.out.println(paintingPlan(3, 4));//0
//        System.out.println(paintingPlan(3, 5));//9
//        System.out.println(paintingPlan(3, 6));//6
        System.out.println(paintingPlan(3, 7));//9
//        System.out.println(paintingPlan(3, 8));//9
//        System.out.println(paintingPlan(3, 9));//1
//        System.out.println(paintingPlan(3, 10));//0
    }

    public int paintingPlan(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (n * n == k) {
            return 1;
        }
        //先计算横多少,竖列多少
        int l = 0;
        int r = 0;
        Map<Integer, Integer> comset = new HashMap<>();
        for (int i = 0; i <n; i++) {
            if (i == n) {
                return 0;
            }

            for (int j = 0; j < n; j++) {
                int total = i * n + j * n - i * j;
                if (total == k) {
                    l = i;
                    r = j;
                    comset.put(l,r);
                }
            }
        }
        if(comset.size()<=0){
            return 0;
        }
        int total=0;
        for(int rkey:comset.keySet()){
            total+=mpicn(n, rkey) * mpicn(n, comset.get(rkey));
        }
       return total;
    }

    @Test
    public void test2() {
        System.out.println(mpicn(6, 0));
        System.out.println(mpicn(6, 1));
        System.out.println(mpicn(6, 2));
        System.out.println(mpicn(6, 4));
        System.out.println(mpicn(6, 5));
        System.out.println(mpicn(6, 6));
    }

    public int mpicn(int n, int m) {
        if (m == 0) {
            return 1;
        }
        if (n == m) {
            return 1;
        }
        int num = 1;
        for (int i = n; i >= 1; i--) {
            num = num * i;
        }
        int ss = 1;
        for (int i = m; i >= 1; i--) {
            ss = ss * i;
        }
        int ss2 = 1;
        for (int i = (n - m); i >= 1; i--) {
            ss2 = ss2 * i;
        }
        return num / (ss * ss2);
    }

}

package leetcode.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaomin
 * @version Id: Leetcode_1202.java, v 1.0 2021/1/14 9:38
 */
public class Leetcode_1018 {
    @Test
    public void test(){
        prefixesDivBy5_fail(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1});
    }

    public List<Boolean> prefixesDivBy5_fail(int[] A) {
        //这个是错的，至于她为什么错，是因为，超出了计算范围后，导致数据不再是正数
        int num = 0;
        List<Boolean> list=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            num=num*2+A[i];// 正确的是方法应该是，只记录最后一位num = (num * 2 + i) % 5;
            list.add((num%5)==0);
            System.out.println(num);

        }
        System.out.println("break");
        prefixesDivBy5(A);
        return list;

    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list=new ArrayList<>();
        int num=0;
        for (int i : A) {
            num = (num * 2 + i) % 5;//优化 num = (num<<1 + i) % 5;
            list.add(num == 0);
            System.out.println(num);
        }
        return list;
    }


}

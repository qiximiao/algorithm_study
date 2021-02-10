package leetcode.leetcode.editor.cn.leetcode.editor.cn.leetcode.editor.cn;

/**
 * @author zhaomin
 * @version Id: Leetcode_978.java, v 1.0 2021/2/10 9:10
 */
public class Leetcode_978 {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(maxTurbulenceSize(new int[]{9,9}));
    }

    public static int maxTurbulenceSize(int[] arr) {
        //动态规划
        int max=1;
        int cur=1;
        boolean zen=true;//是否递增
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                cur=1;
                continue;
            }

            if(i==1){
                if(arr[i]<arr[i-1]){
                    zen=false;
                }
                max=2;
                cur=2;
            }else{
                if((zen&&arr[i]<arr[i-1])||(!zen&&arr[i]>arr[i-1])){
                    cur++;
                    max=Math.max(max,cur);
                    zen=arr[i]>arr[i-1];
                }else{
                    cur=2;
                    zen=arr[i]>arr[i-1];
                }
            }

            //如果不符合，则cur重新变成1,符合则cur+1，并且获取Math,max

        }
        return max;
    }
}

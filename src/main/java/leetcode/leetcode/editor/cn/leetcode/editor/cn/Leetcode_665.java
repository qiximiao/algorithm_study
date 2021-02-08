package leetcode.leetcode.editor.cn.leetcode.editor.cn;

/**
 * @author zhaomin
 * @version Id: Leetcode_665.java, v 1.0 2021/2/7 12:32
 */
public class Leetcode_665 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{-1,4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        boolean hasChange=false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]){//递增
                continue;
            }else{
                if(i==0){
                    hasChange=true;
                    nums[i]=nums[i+1];
                }else{
                    if(!hasChange){
                        if(i==(nums.length-2)){
                            return true;
                        }
                        ////考虑是降低自己，还是抬升后面的值
                        if(nums[i]<=nums[i+2]){

                            //抬升后一位的值
                            hasChange=true;
                            nums[i+1]=nums[i];
                        }else{
                            //降低自身的值
                            if(nums[i-1]<=nums[i+1]){
                                nums[i]=nums[i-1];
                                hasChange=true;
                            }else {
                                return false;
                            }
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

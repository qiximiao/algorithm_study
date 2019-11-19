import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: qiximiao
 * @Date: 2018/9/19
 */
public class LeetCode_1 {

    //暴力法
    public  int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==(nums[i]+nums[j])){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    //hash表(两次循环,可优化为单次循环,即边循环边放值边取用)
    public  int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            int left=target-nums[i];
            if(null!=map.get(left) && map.get(left) != i){
                return new int[]{i,map.get(left)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *
     * //最快执行法,证明错误,错误示例如下
     *     int[] nums = new int[]{1000000,504096,500000,9,1};
     *             int target=1500000;
     *     504096 和500000 的2进制的后11位是一样的
     *      ** 其算法的本质是,X+Y=target,通过X"&"2047(即11位2进制),获取结果的后11位,填充map记录下标(下标不能为0,+1则从1开始),在遍历到Y的时候,发现X"&"2047已经在map中,则可以返回结果
     *      然而,"&"运算只是减少了map的长度,却降低了计算的精度
     *      504096 和500000 的2进制的后11位是一样的,导致"&"结果一致,504096被优先取用,导致错误
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        int max = 2047;
        int[] res = new int[max + 1];

        for (int i = 0, len = nums.length; i < len; i++) {
            int index = (target - nums[i]) & max;
            if (res[index] != 0) {
                return new int[]{res[index] - 1, i};
            }
            res[nums[i] & max] = i + 1;
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1000000,504096,500000,9,1};
        int target=1500000;
        int[] res= twoSum3(nums,target);
        System.out.println( res[0]+","+res[1]);
    }
}

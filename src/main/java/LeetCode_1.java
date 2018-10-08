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


    //hash表
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
}

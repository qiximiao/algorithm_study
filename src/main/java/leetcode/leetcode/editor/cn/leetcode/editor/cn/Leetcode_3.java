package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4576 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class Leetcode_3 {

    public int lengthOfLongestSubstring(String s) {
        int max=s.length();
        int l=0;
        int res=0;
        HashSet<Character> set = new HashSet<>();
        for(int r=0;r<max;r++){
            if(!set.contains(s.charAt(r))){
                res=Math.max(res,r-l+1);
                set.add(s.charAt(r));
            }else{
                while(s.charAt(r)!=s.charAt(l)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
                res=Math.max(res,r-l+1);
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

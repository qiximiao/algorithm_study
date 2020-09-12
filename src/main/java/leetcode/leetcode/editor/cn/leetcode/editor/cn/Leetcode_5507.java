package leetcode.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

public class Leetcode_5507 {
    @Test
    public void test(){
        modifyString("j?qg??b");
    }

    public String modifyString(String s) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                Character pre = null;
                Character end = null;
                if (i != 0) {

                    pre = s.charAt(i - 1);
                    if(pre=='?'){
                        pre=result.charAt(i-1);
                    }
                }
                if (i != s.length() - 1) {
                    end = s.charAt(i + 1);
                }

                result.append(getOne(pre, end));
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public char getOne(Character pre, Character end) {
        if(pre==null&&end==null){
            return 'a';
        }
        if(pre==null){
            return end!='a'?'a':'b';
        }
        if(end==null){
            return pre!='a'?'a':'b';
        }



        if (pre != 'a' && end != 'a') {
            return 'a';
        }
        if (pre != 'b' && end != 'b') {
            return 'b';
        }
        return 'c';
    }
}

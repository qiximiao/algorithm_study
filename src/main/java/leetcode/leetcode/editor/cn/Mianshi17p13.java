package leetcode.leetcode.editor.cn;
//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
// Related Topics 记忆化 字符串 
// 👍 92 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)

/**#面试题 17.13
        恢复空格
 **/
public class Mianshi17p13 {
    public int respace(String[] dictionary, String sentence) {
        return 0;
    }

    @Test
    public void test() {
        String[] dictionary ={ "looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(respace1(dictionary, sentence));
    }

    public int respace1(String[] dictionary, String sentence) {
        //
        if (sentence == null || sentence.length() == 0) {
            return 0;
        }
        if (dictionary == null || dictionary.length == 0) {
            return sentence.length();
        }
        int[] dp = new int[sentence.length() + 1];//dp 长度i的最小未识别字符
        dp[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;//默认增加下标后,字符比之前多一个未识别,通过后续对比减少
            for (int j = 0; j < dictionary.length; j++) {
                if (dictionary[j].length() > i) {
                    continue;//无法处理此长度
                }
                if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
                    dp[i] = Math.min(dp[i - dictionary[j].length()], dp[i]);
                }
            }
        }

        return dp[sentence.length()];
    }


    public int respace2(String[] dictionary, String sentence) {
        return 0;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

package leetcode.leetcode.editor.cn;//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 394 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
//最佳买卖股票时机含冷冻期
public class LetCode_109 {
    @Test
    public void test() {
        int[] a = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
        System.out.println(maxProfit2(a));
        System.out.println(maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        //dp 多个状态转移可以理解,但是怎么做到定义状态意义
        //包含买入,卖出,冷冻三个状态,我们计算的是最大收益 ,中间的状态就是结束状态 ,为了能够影响后续状态变化,我们必须定义好dp状态
        // 是能够识别后一天操作的,首先就是当天不操作(可操作,不可操作),当天操作(买入或卖出,由于结果值我们不考虑买入),
        //如果以操作定义多个状态,类似三叉树,不太方便
        //那么可以是已卖出未冷冻,已卖出冷冻,
        dp[0][0] = -prices[0];//持有股票最大收益
        dp[0][1] = 0;//冷冻期 最大收益
        dp[0][2] = 0;//非冷冻期 最大收益
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);//之前持有股票继续持有,之前是非冷冻期买入
            dp[i][1] = dp[i - 1][0] + prices[i];//之前持有,现在卖出
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);//之前冷冻期继续持有,之前非冷冻期继续持有
        }
        return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]), dp[prices.length - 1][0]);
    }


    //三叉树
    class Node {
        boolean canBuy;//是否可卖出
        boolean canSell;//是否可卖出
        Node left;//买入
        Node right;//卖出
        Node mid;//不操作
        int leftPrice;//当前价格
        int nowHavePrice;//当前持有的股票
        boolean boolHava;//是否持有
    }

    //
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //初始化三叉树
        Node head = new Node();
        head.canBuy = true;
        head.canSell = false;
        head.leftPrice = 0;
        head.nowHavePrice = 0;
        head.boolHava = false;

       return addNode(prices, head, 0);

    }

    private int addNode(int[] prices, Node head, int i) {
        int maxPrice=0;


        if (head.canBuy) {
            Node left = new Node();
            head.left = left;
            left.canBuy = false;
            left.canSell = true;
            left.leftPrice = head.leftPrice-prices[i];
            left.nowHavePrice = prices[i];
            left.boolHava = true;
            if (i < (prices.length-1)) {
                int result=addNode(prices, left, i+1);
                maxPrice=Math.max(maxPrice,result);
            }

        }
        if (head.canSell) {
            Node right = new Node();
            head.right = right;
            right.canBuy = false;//冷冻期
            right.canSell = false;
            right.leftPrice = head.leftPrice+prices[i];
            right.nowHavePrice = prices[i];
            right.boolHava = false;
            if (i < (prices.length-1)) {
                int result=addNode(prices, right, i+1);
                maxPrice=Math.max(maxPrice,result);
            }
        }
        Node mid = new Node();
        head.mid = mid;
        if(!head.boolHava&&!head.canBuy) {//未拥有,本次不可买
            mid.canBuy = true;//下一次可买
        }else{
            mid.canBuy = head.canBuy;
        }
        mid.canSell = head.canSell;
        mid.leftPrice = head.leftPrice;
        mid.nowHavePrice = head.nowHavePrice;
        mid.boolHava = head.boolHava;
        if (i < (prices.length-1)) {
            int result=addNode(prices, mid, i+1);
            maxPrice=Math.max(maxPrice,result);
        }
        //
        if(i==(prices.length-1)){//本次是最末节点
            if(head.right!=null){
                maxPrice=  Math.max(maxPrice,head.right.leftPrice);
            }
            if(head.mid!=null){
                maxPrice=Math.max(maxPrice,head.mid.leftPrice);
            }
        }
        return maxPrice;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

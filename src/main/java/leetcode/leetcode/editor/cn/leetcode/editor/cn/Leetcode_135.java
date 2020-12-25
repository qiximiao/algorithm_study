package leetcode.leetcode.editor.cn.leetcode.editor.cn;//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 431 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Leetcode_135 {
    public int candy(int[] ratings) {
        int[] a=new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                a[i]=a[i-1]+1;
            }else{
                a[i]=1;
            }
        }

        int res=0;
        for(int i=ratings.length-1;i>=0;i--){
            if(i<ratings.length-1&&ratings[i]>ratings[i+1]){
                //反向遍历的时候需要注意，自己本地写一个例子就能看出来
                //1.a[i]的值不用考虑比右边大，如果原来的值比较大，此时是要满足比左边的糖果数要多，此时不能替换
                //2.a[i]需要额外满足比右边的值大,取用的值要么比左边更大,要么就不变动，这样也不会破坏之前的从左往右的结果
                a[i]=Math.max(a[i],a[i+1]+1);
            }
            res+=a[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

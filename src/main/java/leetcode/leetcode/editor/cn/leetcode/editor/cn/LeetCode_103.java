package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 356 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //

        pre(root, 0, result);
        return result;
    }

    public void pre(TreeNode root, int deep, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        //
        if (deep >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        if ((deep % 2) == 0) {
            result.get(deep).add(root.val);
        } else {
            result.get(deep).add(0, root.val);
        }
        pre(root.left, deep + 1, result);
        pre(root.right, deep + 1, result);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

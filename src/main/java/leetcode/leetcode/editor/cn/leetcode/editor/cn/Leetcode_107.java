package leetcode.leetcode.editor.cn.leetcode.editor.cn;//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

import javax.swing.tree.TreeNode;
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


public class Leetcode_107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test(){
        TreeNode root =new TreeNode(3);
        TreeNode root1 =new TreeNode(9);
        TreeNode root2 =new TreeNode(20);
        TreeNode root3 =new TreeNode(15);
        TreeNode root4 =new TreeNode(7);
        root.left=root1;
        root.right=root2;
        root2.left=root3;
        root2.right=root4;
        levelOrderBottom(root);
    }



    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        dfs(root, 0, list);
        //需要反转
        LinkedList<List<Integer>> newlist = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newlist.add(list.get(i));

        }
        return newlist;
    }

    public void dfs(TreeNode root, int deep, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (list.size() <= deep) {
            List<Integer> addList = new LinkedList<>();
            addList.add(root.val);
            list.add(addList);
        } else {
            list.get(deep).add(root.val);
        }
        dfs(root.left, deep + 1, list);
        dfs(root.right, deep + 1, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package leetcode.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_637 {
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
        averageOfLevels(root);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Long> result = new LinkedList<>();
        List<Long> count = new LinkedList<>();
        dfs(result, count, root, 0);
        List<Double> num=new LinkedList<>();
        for (int i=0;i<result.size();i++) {
            num.add(((double)result.get(i))/count.get(i));
        }
        return num;
    }

    public void dfs(List<Long> allList, List<Long> count, TreeNode root, int index) {
        if (root == null) {
            return;
        }

        if (allList.size() < (index + 1)) {
            allList.add(0L);
            count.add(0L);
        }
        allList.set(index, root.val + allList.get(index));
        count.set(index, count.get(index) + 1);
        dfs(allList, count, root.left, index + 1);
        dfs(allList, count, root.right, index + 1);
    }
}

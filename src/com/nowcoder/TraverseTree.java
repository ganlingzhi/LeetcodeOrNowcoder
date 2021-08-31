package com.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class TraverseTree {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        if (root == null) {
            return new int[][] {{}};
        }
        preOrder(root);
        inOrder(root);
        postOrder(root);

        ans.add(pre);
        ans.add(in);
        ans.add(post);
        int[][] res = new int[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); i++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

package com.vincent.树合并;

/**
 * 二叉树合并
 */
public class TreeAdd {

    public static void main(String[] args) {
        TreeNode at2 = new TreeNode(2);
        TreeNode at3 = new TreeNode(3);
        TreeNode at6 = new TreeNode(6);
        TreeNode at7 = new TreeNode(7);
        TreeNode at9 = new TreeNode(9);
        TreeNode ant5 = new TreeNode(-5);


        TreeNode bt1 = new TreeNode(1);
        TreeNode bt2 = new TreeNode(2);
        TreeNode bt4 = new TreeNode(4);
        TreeNode bt9 = new TreeNode(9);
        TreeNode bnt6 = new TreeNode(-6);
        TreeNode bnt7 = new TreeNode(-7);

        TreeNode tree1 = new TreeNode(7);
        tree1.left = at3;
        tree1.left.left = at6;
        tree1.right = ant5;
        tree1.right.left = at2;
        tree1.right.right = at7;
        tree1.right.left.left = at9;

        TreeNode tree2 = new TreeNode(3);
        tree2.left = bt1;
        tree2.left.left = bnt6;
        tree2.right = bt2;
        tree2.right.left = bt4;
        tree2.right.right = bnt7;
        tree2.right.right.right = bt9;
        TreeNode treeNode = mergeTree(tree1, tree2);
        System.out.println(treeNode);

    }

    public static TreeNode mergeTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode result = new TreeNode(t1.val + t2.val);
            if (result.val == 0 && (t1.left == null && t1.right == null && t2.left == null && t2.right == null)) {
                return null;
            }
            if (result.val == 6) {
                System.out.println(result.val);
            }
            result.left = mergeTree(t1.left, t2.left);
            result.right = mergeTree(t1.right, t2.right);
            return result;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}

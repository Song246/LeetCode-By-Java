package tree;

import java.util.*;
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main{
    static TreeNode[] nodes = new TreeNode[30];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int len = sc.nextInt();	// n 行
            for (int i = 0; i < len; i++) {
                // 获取字符和左右⼦节点
                char val = sc.next().charAt(0);
                int left = sc.nextInt();
                int right = sc.nextInt();
            }
            preorder(nodes[1]);
            System.out.println();
            inorder(nodes[1]);
            System.out.println();
            postorder(nodes[1]);
            System.out.println();
        }
    }
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }
}
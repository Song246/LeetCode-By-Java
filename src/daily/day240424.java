package daily;

import java.util.*;

/**
 * 2385. 感染二叉树需要的总时间：树的dfs、树建图dfs、
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-04-24 20:11
 **/
public class day240424 {
    public static void main(String[] args) {

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        // 方法一：树的dfs
        class Solution1 {
        private TreeNode startNode;
        private final Map<TreeNode,TreeNode> fa = new HashMap<>();  // 记录当前节点的父节点，dfs找到start
        public int amountOfTime(TreeNode root, int start) {
            dfs(root,null,start);
            return maxDepth(startNode, startNode);
        }

        private void dfs(TreeNode node,TreeNode from,int start) {
            if(node==null) return;
            fa.put(node,from);  // 记录当前节点的父节点
            if(node.val==start) {
                startNode=node; // 找到start
            }
            dfs(node.left,node,start);
            dfs(node.right,node,start);
        }

        // 可以添加一个递归参数from，表示当前节点是从节点from过来的，我们不去重复访问节点from
        private int maxDepth(TreeNode node, TreeNode from) {
            if(node==null) return -1;
            int res=-1;
            // 递归左右子树，node.left!=from避免由左孩子传给父节点，父节点又去向下递归
            if(node.left!=from) {
                res = Math.max(maxDepth(node.left,node),res);
            }
            // 递归左右子树，node.right!=from避免由右孩子传给父节点，父节点又去向下递归右孩子
            if(node.right!=from) {
                res=Math.max(maxDepth(node.right,node),res);
            }
            // 递归父节点,避免父节点传到子节点，子节点又向上递归回父节点
            if (fa.get(node) != from) {
                res = Math.max(res, maxDepth(fa.get(node), node));
            }
            return res+1;


        }
    }

    // 方法二：树的父节点建图，bfs
    class Solution2 {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();

        public int amountOfTime(TreeNode root, int start) {
            TreeNode startNode = createNewTree(root, start);
            return bfs(startNode);
        }
        // 找start并建图
        private TreeNode createNewTree(TreeNode root, int start) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode ans = null;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.val == start) {
                    ans = poll;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    map.put(poll.left, poll);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    map.put(poll.right, poll);
                }
            }
            return ans;
        }
        // 从start开始bfs,左孩子、右孩子、父节点
        private int bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int ans = -1;
            queue.offer(root);
            set.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode now = queue.poll();
                    if (now.left != null && !set.contains(now.left)) {
                        set.add(now.left);
                        queue.offer(now.left);
                    }
                    if (now.right != null && !set.contains(now.right)) {
                        queue.offer(now.right);
                        set.add(now.right);
                    }
                    if (map.get(now) != null & !set.contains(map.get(now))) {
                        queue.offer(map.get(now));
                        set.add(map.get(now));
                    }
                }
                ans++;
            }
            return ans;
        }
    }

}

import java.util.*;

public class Solution {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        Integer val;
    }
    /**
     * 两数之和
     * 数组中只有一个解，并且每个元素只能用一次
     * 利用哈希 时间复杂度是 O(n)  空间复杂度是 O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 二叉树的中序遍历
     */
    List<Integer> res = new ArrayList();

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal1(root.left);
        res.add(root.val);
        inorderTraversal1(root.right);
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        Deque<TreeNode> stack = new ArrayDeque();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * 二叉树的前序遍历
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        Deque<TreeNode> stack = new ArrayDeque();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    /**
     * N 叉树的层序遍历
     * @param
     * @return
     */
    class Node{
        List<Node> children;
        Integer  val;
    }
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                //如果是二叉输 可以改下面
                List<Node> nodeList = node.children;
                for (Node n :nodeList){
                    queue.add(n);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
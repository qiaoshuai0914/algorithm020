public class Solution {
    /**
     * 两数之和
     * 数组中只有一个解，并且每个元素只能用一次
     * 利用哈希 时间复杂度是 O(n)  空间复杂度是 O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.legth; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] = target) {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Deque<Integer> stack = new ArrayDeque();
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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Deque<Integer> stack = new ArrayDeque();
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
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArraList();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArraList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll;
                temp.add(node.val);
                //如果是二叉输 可以改下面
                List<Node> nodeList = node.children();
                while (List < Node > node :nodeList){
                    queue.add(node);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
public class Solution {
    //二叉树的最近公共祖先 1，、.递归实现
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result ;
        dfs(root, p, q,result);
        return result;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q,TreeNode result) {
        //终止条件
        if (root == null) return false;
        //进入到下一层
        boolean lson = dfs(root.left, p, q,result);
        boolean rson = dfs(root.right, p, q,result);
        //合并子问题 1.如果左右子树都包含p和q 则 root为最近公共祖先
        //2.如果当前层 root是其中的一个p或者q；并且root的左右子树中包含另外的节点则 root是最近公共祖先
        if ((lson && rson)
                || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            result = root;
        }
        //只要有一个是ture 则返回包含q或q；
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    //全排列问题
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
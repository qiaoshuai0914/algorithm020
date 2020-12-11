
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class Solution_3 {
    /**
     * 广度优先搜索遍历二叉树就是层级遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        List<List<Integer>>  result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer>  temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode treeNode =queue.remove();
                temp.add(treeNode.val);
                if(treeNode.left !=null){
                    queue.add(treeNode.left);
                }
                if( treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }
        return  result;
    }

    /**
     * 深度优先搜索
     * 前中后序遍历为深度优先搜索，然后加入层级的就是深度优先搜索，完成层级遍历；
     *
     * @param result
     * @param root
     * @param level
     */
    public void levelOrderDfs( List<List<Integer>> result,TreeNode root,Integer level) {

        if(root==null){
            return ;
        }
        if(result.get(level)==null){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrderDfs(result,root.left,level+1);
        levelOrderDfs(result,root.right,level+1);

    }



    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
}

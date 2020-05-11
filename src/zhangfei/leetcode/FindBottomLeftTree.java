package zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/3/29.
 */
class Result {
    int height;
    int val;

    public Result(int height, int val) {
        this.height = height;
        this.val = val;
    }
}

public class FindBottomLeftTree {
    //返回树高和最左侧的值，然后比较子树的树高，返回树高的那个值。
    public int findBottomLeftValue(TreeNode root) {
        Result result = helper(root);
        return result.val;
    }

    private Result helper(TreeNode node) {
        if (node == null) return null;
        Result leftResult = helper(node.left);
        Result rightResult = helper(node.right);
        //如果是叶子节点，直接返回
        if (leftResult == null && rightResult == null)
            return new Result(1, node.val);
        //如果没有左侧树，则返回右侧树的值
        if (leftResult == null) {
            rightResult.height++;
            return rightResult;
        }
        //如果没有右侧树，则返回左侧树的值
        if (rightResult == null) {
            leftResult.height++;
            return leftResult;
        }
        //如果左侧树的树高较高，则返回左侧树
        if (leftResult.height >= rightResult.height) {
            leftResult.height++;
            return leftResult;
        } else {
            rightResult.height++;
            return rightResult;
        }
    }
}

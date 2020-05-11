package zhangfei.offer;

/**
 * Created by zhangfei614 on 2017/7/15.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PostOrder {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] arr, int s, int e) {
        if (arr == null || s > e) return false;
        if (s == e) return true;
        int root = arr[e];
        //找到左子树
        int i = s;
        for (; i < e; i++) {
            if (arr[i] > root)
                break;
        }
        int j = i;
        for (; j < e; j++) {
            if (arr[j] < root)
                return false;
        }
        boolean lflag = true, rflag = true;
        if (i - 1 >= s)
            lflag = verify(arr, s, i - 1);
        if (e - 1 >= i)
            rflag = verify(arr, i, e - 1);
        return lflag & rflag;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 7, 5};
        System.out.println(new PostOrder().VerifySquenceOfBST(arr));

    }
}

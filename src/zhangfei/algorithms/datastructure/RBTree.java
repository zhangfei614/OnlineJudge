package tsinghua.cs.zhangfei.algorithms.datastructure;

/**
 * Created by Fei Zhang on 2017/4/7.
 * Email:zhangfei614@126.com
 * - 每个节点或者黑色，或者是红色。
 * - 根节点是黑色。
 * - 每个叶子结点（NIL）是黑色。
 * - 如果一个结点是红色，它的子节点必须是黑色。
 * - 从一个结点到该节点的子孙叶子结点的所有路径上包含相同数目的黑色结点。（确保没有一条路径会比其他路径长出两倍，接近于平衡二叉树。）
 */


public class RBTree<T extends Comparable<T>> {
    static final boolean RED = true;
    static final boolean BLACK = false;


    private RBNode<T> root;

    static final class RBNode<T extends Comparable<T>> {
        T value;
        RBNode<T> left;
        RBNode<T> right;
        RBNode<T> parent;
        boolean color;

        RBNode(T value) {
            this.value = value;
        }

        RBNode(T value, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.value = value;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        boolean isRed() {
            return color;
        }
    }

    public RBTree() {
        this.root = null;
    }

    /**
     * 对X进行左旋，意味着，将“X的右孩子”设为“X的父亲节点”；
     * 即，将 X变成了一个左节点。 因此，左旋中的“左”，意味着“被旋转的节点将变成一个左节点”。
     *
     * @param node
     */
    private void leftRotate(RBNode<T> node) {
        if (node != null) {
            RBNode r = node.right;
            node.right = r.left;
            if (r.left != null)
                r.left.parent = node;
            r.parent = node.parent;
            if (node.parent == null)
                this.root = r;
            else if (node == node.parent.left)
                node.parent.left = r;
            else
                node.parent.right = r;
            r.left = node;
            node.parent = r;
        }
    }

    /**
     * 对X进行右旋，意味着，将“X的左孩子”设为“X的父亲节点”；
     * 即，将X变成了一个右节点。因此，右旋中的“右”，意味着“被旋转的节点将变成一个右节点”。
     *
     * @param node
     */
    private void rightRotate(RBNode<T> node) {
        if (node != null) {
            RBNode l = node.left;
            node.left = l.right;
            if (l.right != null)
                l.right.parent = node;
            l.parent = node.parent;
            if (node.parent == null)
                this.root = l;
            else if (node.parent.left == node)
                node.parent.left = l;
            else
                node.parent.right = l;
            l.right = node;
            node.parent = l;
        }
    }


    private RBNode find(T value){
        int cmp;
        RBNode t = this.root;
        if (t == null) return null;
        do {
            cmp = value.compareTo((T) t.value);
            if (cmp < 0)
                t = t.left;
            else if (cmp > 0)
                t = t.right;
            else
                return t;
        } while (t != null);
        return null;
    }

    /**
     * 插入一个值：
     * 1. 将红黑树作为二叉查找树，将结点插入。
     * 2. 将插入结点的颜色置为"红色"。
     * 3. 通过旋转或者着色等操作，将二叉树重新变为一个红黑树。
     * 如果有值，则返回引用；没有值则返回null
     *
     * @param value
     * @return
     */
    public RBNode insert(T value) {
        int cmp;
        RBNode parent, t = this.root;
        //如果根为空，则直接插入。
        if (t == null) {
            RBNode node = new RBNode(value);
            this.root = node;
            return null;
        }
        do {
            parent = t;
            cmp = value.compareTo((T) t.value);
            if (cmp < 0)
                t = t.left;
            else if (cmp > 0)
                t = t.right;
            else
                return t;
        } while (t != null);
        RBNode node = new RBNode(value, RED, parent, null, null);
        if (cmp < 0)
            parent.left = node;
        else
            parent.right = node;
        fixAfterInsertion(node);
        return null;
    }

    /**
     * 插入值后的调整：
     * - 如果被插入节点是根节点，则直接将该结点涂为黑色。
     * - 如果被插入节点的父节点是黑色，则不需要处理，认为红黑树。
     * - 如果被插入节点的父节点是红色，则需要根据叔叔结点的情况进行进一步处理。
     * | Case 1|当前节点的父节点是红色，叔叔节点也是红色。| (01) 将“父节点”设为黑色。(02) 将“叔叔节点”设为黑色。(03) 将“祖父节点”设为“红色”。(04) 将“祖父节点”设为“当前节点”(红色节点)|
     * | Case 2|当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的右孩子 | 	(01) 将“父节点”作为“新的当前节点”。(02) 以“新的当前节点”为支点进行左旋。|
     * | Case 3|当前节点的父节点是红色，叔叔节点是黑色，且当前节点是其父节点的左孩子|(01) 将“父节点”设为“黑色”。(02) 将“祖父节点”设为“红色”。(03) 以“祖父节点”为支点进行右旋。|
     *
     * @param node
     */
    private void fixAfterInsertion(RBNode node) {
        node.color = RED;
        while (node != null && node != root && colorOf(parentOf(node))== RED) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                RBNode uncle = rightOf(parentOf(parentOf(node)));
                //case 1
                if (colorOf(uncle) == RED) {
                    setColor(parentOf(node),BLACK);
                    setColor(uncle,BLACK);
                    setColor(parentOf(parentOf(node)),RED);
                    node = parentOf(parentOf(node));
                } else {
                    //case 2
                    if (node == rightOf(parentOf(node))) {
                        node = parentOf(node);
                        leftRotate(node);
                    }
                    //case 3
                    setColor(parentOf(node),BLACK);
                    setColor(parentOf(parentOf(node)),RED);
                    rightRotate(parentOf(parentOf(node)));
                }
            } else {
                RBNode uncle = leftOf(parentOf(parentOf(node)));
                if (colorOf(uncle) == RED) {
                    setColor(parentOf(node),BLACK);
                    setColor(uncle,BLACK);
                    setColor(parentOf(parentOf(node)),RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == leftOf(parentOf(node))) {
                        node = parentOf(node);
                        rightRotate(node);
                    }
                    setColor(parentOf(node),BLACK);
                    setColor(parentOf(parentOf(node)),RED);
                    leftRotate(parentOf(parentOf(node)));
                }
            }
        }
        root.color = BLACK;
    }

    /**
     * 删除一个值：
     * 1. 将红黑树作为二叉查找树，将节点删除。
     * - 如果是叶节点，直接将叶节点删除。
     * - 如果删除结点只有一个儿子，将其子节点顶替其位置。
     * - 如果有两个非空子节点，则需要找出其后继节点。然后把后继节点替换到当前位置，并递归地删除后继节点。
     * 2. 通过“旋转和着色”来修正该树，使之重新成为一颗红黑树。
     *
     * @param value
     * @return
     */
    public void delete(T value) {
        RBNode t = find(value);
        if (t == null) return;
        //如果是双非空子节点，找到后继，并替换
        if (t.left != null && t.right != null) {
            RBNode successor = successor(t);
            t.value = successor.value;
            t = successor;
        }
        RBNode replacement = t.left != null ? t.left : t.right;
        //如果是单非空子节点，则直接删除替换
        if (replacement != null) {
            replacement.parent = t.parent;
            if (t.parent == null) {
                root = replacement;
            } else if (t == t.parent.left) {
                t.parent.left = replacement;
            } else {
                t.parent.right = replacement;
            }
            t.parent = t.left = t.right = null;
            //如果是双空结点
        } else if (t.parent == null) {
            this.root = null;
        } else {
            if (t.color == BLACK)
                fixAfterDeletion(t);
            if (t.parent != null) {
                if (t == t.parent.left)
                    t.parent.left = null;
                else if (t == t.parent.right)
                    t.parent.right = null;
                t.parent = null;
            }
        }

    }

    /**
     * 寻找后继结点
     * //在查找过程中，如果节点x右子树不为空，那么返回右子树的最小节点即可
     * //如果节点x的右子树为空，那么后继节点为x的某一个祖先节点的父节点，而且该祖先节点是作为其父节点的左儿子
     *
     * @param node
     * @return
     */
    private RBNode successor(RBNode node) {
        if (node == null) return null;
        if (node.right != null) {
            RBNode p = node.right;
            while (p.left != null) p = p.left;
            return p;
        } else {
            RBNode p = node.parent;
            while (p != null && node == p.right) {
                node = p;
                p = p.parent;
            }
            return p;
        }
    }

    /**
     * 基本思路：
     * 删除操作的总体思想是从兄弟节点借调黑色节点使树保持局部的平衡，如果局部的平衡达到了，就看整体的树是否是平衡的，如果不平衡就接着向上追溯调整。
     * | Case 1| X是黑色结点，X的兄弟是红色结点，并且X的兄弟的子节点都是黑色节点|(01) 将x的兄弟节点设为“黑色”。(02) 将x的父节点设为“红色”。(03) 对x的父节点进行左旋。（无法从兄弟结点借调黑色结点，将兄弟结点上升，从兄弟结点的子节点借调，将其转换为Case 2,3,4）|
     * | Case 2| X是黑色结点，X的兄弟是黑色结点，并且X的兄弟的子节点都是黑色节点。|	(01) 将x的兄弟节点设为“红色”。(02) 设当前结点为X的父节点。（把兄弟结点变红后，有可能导致祖父结点失去平衡，因此需要回溯到父节点进行调整。）|
     * | Case 3| X是黑色结点，X的兄弟是黑色结点，兄弟结点的左孩子是红色结点。|(01) 将x兄弟节点的左孩子设为“黑色”。(02) 将x兄弟节点设为“红色”。(03) 对x的兄弟节点进行右旋。（中间状态，借用侄子结点的红色，变成黑色来平衡查找树。）|
     * | Case 4| X是黑色结点，X的兄弟是黑色结点，兄弟结点的右孩子是红色结点。|	(01) 将x父节点颜色 赋值给 x的兄弟节点。(02) 将x父节点设为“黑色”。(03) 将x兄弟节点的右子节设为“黑色”。(04) 对x的父节点进行左旋。(05) 设置“x”为“根节点”。（将兄弟结点的左黑色结点借调过来。）|
     *
     * @param node
     */
    private void fixAfterDeletion(RBNode node) {
        while (node != root && colorOf(node) == BLACK) {
            if (node == leftOf(parentOf(node))) {
                RBNode sib = rightOf(parentOf(node));
                if(colorOf(sib) == RED){
                    setColor(sib,BLACK);
                    setColor(parentOf(node),RED);
                    leftRotate(parentOf(node));
                    sib = rightOf(parentOf(node));
                }
                if(colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK){
                    setColor(sib,RED);
                    node = parentOf(node);
                }else{
                    if(colorOf(rightOf(sib)) == BLACK){
                        setColor(leftOf(sib),BLACK);
                        setColor(sib,RED);
                        rightRotate(sib);
                        sib = rightOf(parentOf(node));
                    }
                    setColor(sib,colorOf(parentOf(node)));
                    setColor(parentOf(node),BLACK);
                    setColor(rightOf(sib),BLACK);
                    leftRotate(parentOf(node));
                    node = root;
                }
            } else {
                RBNode sib = leftOf(parentOf(node));
                if(colorOf(sib) == RED){
                    setColor(sib,BLACK);
                    setColor(parentOf(node),RED);
                    rightRotate(parentOf(node));
                    sib = leftOf(parentOf(node));
                }
                if(colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK){
                    setColor(sib,RED);
                    node = parentOf(node);
                }else{
                    if(colorOf(leftOf(sib)) == BLACK){
                        setColor(rightOf(sib),BLACK);
                        setColor(sib,RED);
                        leftRotate(sib);
                        sib = leftOf(parentOf(node));
                    }
                    setColor(sib,colorOf(parentOf(node)));
                    setColor(parentOf(node),BLACK);
                    setColor(leftOf(sib),BLACK);
                    rightRotate(parentOf(node));
                    node = root;
                }
            }
        }
    }


    public void preOrder(){
        preOrderHelper(this.root);
        System.out.println();
    }
    private void preOrderHelper(RBNode node){
        if(node == null) return;
        System.out.print("(" + node.value.toString() + "," + colorName(colorOf(node)) + ")");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }

    public void midOrder(){
        midOrderHelper(this.root);
        System.out.println();
    }

    private void midOrderHelper(RBNode node){
        if(node == null) return;
        midOrderHelper(node.left);
        System.out.print("(" + node.value.toString() + "," + colorName(colorOf(node)) + ")");
        midOrderHelper(node.right);
    }


    private static boolean colorOf(RBNode p) {
        return (p == null ? BLACK : p.color);
    }

    private static RBNode parentOf(RBNode p) {
        return (p == null ? null : p.parent);
    }

    private static void setColor(RBNode p, boolean c) {
        if (p != null)
            p.color = c;
    }

    private static RBNode leftOf(RBNode p) {
        return (p == null) ? null : p.left;
    }

    private static RBNode rightOf(RBNode p) {
        return (p == null) ? null : p.right;
    }

    private static String colorName(boolean color){
        return color == RED ? "RED" : "BLACK";
    }


    public static void main(String[] args){
        Integer[] test = new Integer[]{1,2,3,4,5,6,7,8};
        RBTree<Integer> rbTree = new RBTree<Integer>();
        for(Integer integer: test) rbTree.insert(integer);
        rbTree.delete(4);
        rbTree.preOrder();
        rbTree.midOrder();
    }
}

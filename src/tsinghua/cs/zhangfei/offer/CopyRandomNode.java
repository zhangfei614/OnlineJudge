package tsinghua.cs.zhangfei.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei614 on 2017/7/15.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CopyRandomNode {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        pHead = copyList(pHead);
        pHead = copyRandomPtr(pHead);
        return splitList(pHead);
    }

    private RandomListNode copyList(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        return head;
    }

    private RandomListNode copyRandomPtr(RandomListNode head) {
        RandomListNode p = head;
        while (p != null && p.random != null) {
            p.next.random = p.random.next;
            p = p.next.next;
        }
        return head;
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next, p = head, q = head.next;
        while (p != null) {
            p.next = q.next;
            p = q.next;
            if (p != null)
                q = p.next;
        }
        return newHead;
    }

    public RandomListNode CloneMap(RandomListNode pHead) {
        if (pHead == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode head = new RandomListNode(0), p = pHead, q = head;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            q.next = node;
            map.put(p, node);
            p = p.next;
            q = q.next;
        }
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;
        RandomListNode newHead = new CopyRandomNode().CloneMap(node1);
        while (newHead != null) {
            System.out.println(newHead.label + "" + newHead.random.label);
            newHead = newHead.next;
        }
    }

    private void printNode(RandomListNode node) {
        while (node != null) {
            System.out.println(node.label);
            node = node.next;
        }
    }
}

package com.algorithm;

/**
 * 链表中倒数第k个节点
 * Created by zhangfeifei2 on 2017/7/12.
 */
class LinkNode {
    int data;
    LinkNode next;
}


public class ReverseKthNode {
    public static LinkNode findKthToLast(LinkNode head, int k) {
        if (head == null || k <= 0)
            return null;
        LinkNode resultNode = null;
        LinkNode headLinkNode = head;
        for (int i = 0; i < k - 1; i++) {
            if (headLinkNode.next != null) {
                headLinkNode = headLinkNode.next;
            } else {
                return null;
            }
        }
        resultNode =  head;
        while (headLinkNode.next != null) {
            resultNode = resultNode.next;
            headLinkNode = headLinkNode.next;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        LinkNode head = new LinkNode();
        head.data = 8;
        LinkNode second = new LinkNode();
        second.data = 2;
        LinkNode third = new LinkNode();
        third.data = 5;
        LinkNode fourth = new LinkNode();
        fourth.data = 0;
        head.next = second;
        second.next = third;
        third.next = fourth;
        LinkNode k = findKthToLast(head, 2);
        System.out.println(k.data);
    }
}
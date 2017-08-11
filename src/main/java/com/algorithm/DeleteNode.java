package com.algorithm;

/**
 * @desc 在O(1)时间内删除链表节点
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/12.
 */
public class DeleteNode {
    public static void deleteNode(ListNode head, ListNode deListNode) {
        if(deListNode == null || head == null)
            return;
        if(head == deListNode) {
            head = head.next;
        } else {
            if(deListNode.next == null) {//删除尾结点，顺序遍历得到前一个结点
                ListNode pointListNode = head;//从头结点开始
                while(pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {//删除的不是尾结点
                deListNode.data = deListNode.next.data;
                deListNode.next = deListNode.next.next;
            }
        }
    }
}

class ListNode {
    int data;
    ListNode next = null;
}
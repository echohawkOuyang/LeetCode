/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *示例：
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *输出：7 -> 0 -> 8
 *原因：342 + 465 = 807
 */

import java.math.BigInteger;

/**
 * 好晚了，大数解决不了，明天来；
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Test2_1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();

        for (ListNode listNode = l1; listNode != null; listNode=listNode.next)
            sb.insert(0,listNode.val);
        BigInteger num1 = new BigInteger(sb.toString());
        sb.delete(0, sb.length());
        for (ListNode listNode = l2; listNode != null; listNode=listNode.next)
            sb.insert(0,listNode.val);
        BigInteger num2 = new BigInteger(sb.toString());
        BigInteger total = num1.add(num2);
        ListNode node;
        ListNode list;
        BigInteger ten = new BigInteger("10");
        for (list = new ListNode(Integer.parseInt(""+(total.mod(ten)))), node = list;
             !total.divide(ten).equals(new BigInteger("0"));
             total = total.divide(ten),list = list.next = new ListNode(Integer.parseInt(""+(total.mod(ten)))));
        return node;
    }

    public static void main(String[] args) {
        /*ListNode node1 = new ListNode(9);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;*/
        ListNode node1 = new ListNode(2);

        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node6.next = node7;
        node7.next = node8;
        ListNode node14 = addTwoNumbers(node1,node6);
        for (; node14.next != null; node14 = node14.next)
            System.out.print(node14.val);
    }
}

import java.math.BigInteger;

/**
 * 这个倒是通过了，第一次，有点小开心
 * 不过运行时间  超过了15.23%   额
 * 好菜
 * 这里主要用了BigInteger，后期优化
 */


public class Test2_2 {
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
}

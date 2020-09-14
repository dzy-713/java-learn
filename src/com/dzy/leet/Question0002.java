package com.dzy.leet;

/**
 * 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question0002 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 遍历ListNode,模拟加法进位操作
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //当前位置
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        //结果对象
        ListNode result = null;
        ListNode preNode = null;
        //进位标志
        boolean carryFlag = false;
        do {
            int num1 = currentL1 != null ? currentL1.val : 0;
            int num2 = currentL2 != null ? currentL2.val : 0;
            int newVal = num1 + num2 + (carryFlag == true ? 1 : 0);
            if (newVal >= 10) {
                carryFlag = true;
                newVal = newVal % 10;
            } else {
                carryFlag = false;
            }
            if (result == null) {
                result = new ListNode(newVal);
                preNode = result;
            } else {
                preNode.next = new ListNode(newVal);
                preNode = preNode.next;
            }
            currentL1 = currentL1 != null ? currentL1.next : null;
            currentL2 = currentL2 != null ? currentL2.next : null;
        } while (currentL1 != null || currentL2 != null || carryFlag);
        return result;
    }

    /**
     * 链表转数字,数字相加后再转链表
     * 放弃的答案,有int越界的情况发生
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int num1 = linkToInt(l1);
        int num2 = linkToInt(l2);
        return intToLink(num1 + num2);
    }

    /**
     * 链表转数字,链表是逆序排列的
     *
     * @param listNode
     * @return
     */
    public int linkToInt(ListNode listNode) {
        StringBuffer stringBuffer = new StringBuffer();
        do {
            int val = listNode.val;
            stringBuffer.insert(0, val);
            listNode = listNode.next;
        } while (listNode != null);
        return Integer.parseInt(stringBuffer.toString());
    }

    /**
     * 数字转成逆序链表
     *
     * @param num
     * @return
     */
    public ListNode intToLink(int num) {
        int divRate = 10;
        ListNode listNode = new ListNode(num % divRate);
        ListNode currentNode = listNode;
        ListNode nextNode;
        if (num < 10) {
            return listNode;
        }
        num = num / divRate;
        do {
            nextNode = new ListNode(num % divRate);
            currentNode.next = nextNode;
            currentNode = nextNode;
            num = num / divRate;
        } while (num > 0);
        return listNode;
    }

    public static void main(String[] args) {

        ListNode l1 = new Question0002().intToLink(9);
        ListNode l2 = new Question0002().intToLink(999999999);
        ListNode result = new Question0002().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}

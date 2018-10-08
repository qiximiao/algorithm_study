package main.java;

import org.junit.Test;

/**
 * @Auther: qiximiao
 * @Date: 2018/9/19
 */
public class LeetCode_2 {

//    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 8
//    原因：342 + 465 = 807
//    输入：(2 -> 4) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 5
//    原因：42 + 465 = 507
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode a=l1;
    ListNode b=l2;
    ListNode head=new ListNode(0);
    ListNode c=head;//c.next存节点

    int addNum=0;
    while(a!=null||b!=null){
        int x=(a!=null)?a.val:0;
        int y=(b!=null)?b.val:0;
        int sum=addNum+x+y;
        addNum=sum/10;
        c.next=new ListNode(sum%10);
        c=c.next;
        a=(a!=null)?a.next:a;
        b=(b!=null)?b.next:b;
    }
    if(addNum>0){
        c.next=new ListNode(addNum);
    }
    return head.next;
}



    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    @Test
    public void test(){
        ListNode a1=new ListNode(3);
        a1.next=new ListNode(4);
        a1.next.next=new ListNode(2);
        ListNode a2=new ListNode(4);
        a2.next=new ListNode(6);
        a2.next.next=new ListNode(5);
        ListNode res = addTwoNumbers(a1,a2);
        System.out.println(res.val+""+res.next.val+""+res.next.next.val);
    }
}

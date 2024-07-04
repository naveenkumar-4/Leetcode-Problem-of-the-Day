
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public static ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode dummy = new ListNode(-1);
        ListNode dummyFinal = dummy;
        int sum = 0;
        while (temp != null) {
            if (temp.val != 0) {
                sum += temp.val;
            } else {
                ListNode newDummy = new ListNode(sum);
                dummy.next = newDummy;
                dummy = dummy.next;
                sum = 0;
            }
            temp = temp.next;
        }
        return dummyFinal.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        ListNode res = mergeNodes(head);
        while (res != null) {
            System.out.print(res.val + "->");
            res=res.next;
        }
    }
}
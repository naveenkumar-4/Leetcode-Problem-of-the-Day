import java.util.ArrayList;

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
    public static int[] nodesBetweenCriticalPoints(ListNode head) {

        int ans[] = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int prevVal = head.val;
        ListNode curr = head.next;
        int firstCIndex = -1, prevCIndex = 0, id = 1;
        while (curr.next != null) {
            int currVal = curr.val;
            int nextVal = curr.next.val;
            if ((currVal > prevVal && currVal > nextVal) || (currVal < prevVal && currVal < nextVal)) {
                if (firstCIndex == -1) {
                    firstCIndex = id;
                } else {
                    ans[0] = Math.min(ans[0], id - prevCIndex);
                    ans[1] = Math.max(ans[1], id - firstCIndex);
                }
                prevCIndex = id;
            }
            prevVal = currVal;
            curr = curr.next;
            id++;
        }
        if (ans[0] == Integer.MAX_VALUE) {
            int arr[] = { -1, -1 };
            return arr;
        }
        return ans;

    }

    public static void main(String[] args) {
        // create a linkedList 5->3->1->2->5->1->2
        ListNode node7 = new ListNode(2);
        ListNode node6 = new ListNode(1, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode head = new ListNode(5, node2);

        Solution solution = new Solution();
        int[] result = solution.nodesBetweenCriticalPoints(head);

        System.out.println("Minimum Distance: " + result[0]);
        System.out.println("Maximum Distance: " + result[1]);
    }
}
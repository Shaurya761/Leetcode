import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

    // Deserialize a string like "[2,4,3]" to a linked list
    public static ListNode deserialize(String s) {
        s = s.replaceAll("\\[|\\]|\\s", ""); // remove brackets and spaces
        if (s.isEmpty()) return null;
        String[] parts = s.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }
        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(",");
            current = current.next;
        }
        System.out.println("]");
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Example 1
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        // Print the result
        ListNode.printList(result); // Output: [7,0,8]
    }
}

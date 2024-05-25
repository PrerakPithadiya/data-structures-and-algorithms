package linkedlist;

class PalindromicLinkedList {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }


        // step 1: find middle
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        // step 2: reverse second half
        Node i = null;
        Node j = slow;
        Node k;
        while (j != null) {
            k = j.next;
            j.next = i;
            i = j;
            j = k;
        }


        // step 3: check palindromic
        j = i;
        i = head;
        while (j != null) {
            if (i.data != j.data) {
                return false;
            }
            i = i.next;
            j = j.next;
        }

        return true;
    }
}

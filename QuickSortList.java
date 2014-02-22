public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

private static class HeadTail {
	ListNode head;
	ListNode tail;
	HeadTail(ListNode h, ListNode t) {
		head = h;
		tail = t;
	}
}

public static HeadTail quickSortList(ListNode head) {
	if(head == null || head.next == null) return new HeadTail(head, head);
	ListNode pivot = head;
	head = head.next;
	pivot.next = null;
	int piv = pivot.val;
	ListNode firstHead = null, firstTail = null, secondHead = null, secondTail = null;
	while(head != null) {
		if(head.val < piv) {
			if(firstHead == null) {
				firstHead = head;
				firstTail = head;
			} else {
				firstTail.next = head;
				firstTail = firstTail.next;
			}
		} else {
			if(secondHead == null) {
				secondHead = head;
				secondTail = head;
			} else {
				secondTail.next = head;
				secondTail = secondTail.next;
			}
		}
		head = head.next;
	}
	if(firstTail != null) firstTail.next = null;
	if(secondTail != null) secondTail.next = null;
	HeadTail first = quickSortList(firstHead);
	HeadTail second = quickSortList(secondHead);
	pivot.next = second.head;
	if(first.head == null) return new HeadTail(pivot, second.tail);
	first.tail.next = pivot;
	return new HeadTail(first.head, second.tail);
}


















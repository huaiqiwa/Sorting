public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public static ListNode mergeSortList(ListNode head) {
	if(head == null || head.next == null) return head;
	int cur = head, runner = head.next;
	while(runner != null && runner.next != null) {
		cur = cur.next;
		runner = runner.next.next;
	}
	ListNode nextHead = cur.next;
	cur.next = null;
	ListNode first = mergeSortList(head);
	ListNode second = mergeSortList(nextHead);
	return mergeList(first, second);
}

private static ListNode mergeList(ListNode first, ListNode second) {
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	while(first != null && second != null) {
		if(first.val < second.val) {
			cur.next = first;
			first = first.next;
		} else {
			cur.next = second;
			second = second.next;
		}
		cur = cur.next;
	}
	cur.next = (first != null ? first : second);
	return dummy.next;
}




private int left = Integer.MIN_VALUE;
private int right = Integer.MAX_VALUE;
private Random ran = new Random();
public static void quickSort(int[] nums) {
	if(nums.length < 2) return;
	Queue<Integer> indexes = new LinkedList<Integer>();
	indexes.offer(0);
	indexes.offer(nums.length-1);
	while(!indexes.isEmpty()) {
		int start = indexes.poll();
		int end = indexes.poll();
		partiton(nums, start, end);
		if(left > start) {
			indexes.offer(start);
			indexes.offer(left);
		}
		if(right < end) {
			indexes.offer(right);
			indexes.offer(end);
		}
	}
}

private static int partition(int[] nums, int start, int end) {
	int ipivot = start + ran.nextInt(end-start+1);
	int pivot = nums[ipivot];
	left = start, right = end;
	for(int i = start; i <= end; i++) {
		if(nums[i] < pivot) {
			swap(nums, i, left);
			left++;
		} else if(nums[i] > pivot) {
			swap(nums, i, right);
			right--;
			i--;
		}
	}
	left--; right++;
}

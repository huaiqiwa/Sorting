public static void mergeSort(int[] nums) {
	if(nums.length < 2) return;
	int[] helper = new int[nums.length];
	for(int offset = 1; offset < nums.length; offset*=2) {
		for(int i = 0; i+offset-1 < nums.length; i+=2*offset) {
			merge(nums, i, i+offset-1, Math.min(i+2*offset-1, nums.length-1), helper);
		}
	}
}

private static void merge(int[] nums, int start, int mid, int end, int[] helper) {
	if(mid >= end) return;
	int l1 = start, r1 = mid, l2 = mid+1, r2 = end, l = start;
	while(l1 <= r1 && l2 <= r2) {
		if(nums[l1] < nums[l2]) {
			helper[l] = nums[l1];
			l1++;
		} else {
			helper[l] = nums[l2];
			l2++;
		}
		l++;
	}
	while(l1 <= r1) {
		helper[l] = nums[l1];
		l1++;
		l++;
	}
	for(int i = start; i <= end; i++) {
		nums[i] = helper[i];
	}
}
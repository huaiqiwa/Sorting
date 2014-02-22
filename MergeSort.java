public static void mergeSort(int[] nums) {
	if(nums.length < 2) return;
	int[] helper = new int[nums.length];
	mergeSort(nums, 0, nums.length-1, helper);
}

private static void mergeSort(int[] nums, int start, int end, int[] helper) {
	if(start >= end) return;
	int mid = start + (end-start)/2;
	mergeSort(nums, start, mid, helper);
	mergeSort(nums, mid+1, end, helper);
	merge(nums, start, mid, end, helper);
}

private static void merge(int[] nums, int start, int mid, int end, int[] helper) {
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



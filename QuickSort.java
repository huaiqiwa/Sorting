public static void quickSort(int[] nums) {
	if(nums.length < 2) return;
	quickSort(nums, 0, nums.length-1);
}

private static void quickSort(int[] nums, int start, int end) {
	if(start >= end) return;
	int pivot = nums[end];
	int left = start, right = end-1;
	while(left <= right) {
		while(left<=right && nums[left]<=pivot) left++;
		while(left<=right && nums[right]>=pivot) right--;
		if(left<right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
	}
	nums[end] = nums[left];
	nums[left] = pivot;
	quickSort(nums, start, left-1);
	quickSort(nums, left+1, end);
}

//choose random number as pivot
private static void quickSort(int[] nums, int start, int end, Random ran) {
	if(start >= end) return;
	int ranIndex = ran.nextInt(end-start+1) + start;
	int temp = nums[ranIndex];
	nums[ranIndex] = nums[end];
	nums[end] = temp;
	int pivot = nums[end];
	int left = start, right = end-1;
	while(left <= right) {
		while(left<=right && nums[left]<=pivot) left++;
		while(left<=right && nums[right]>=pivot) right--;
		if(left<right) {
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
	}
	nums[end] = nums[left];
	nums[left] = pivot;
	quickSort(nums, start, left-1);
	quickSort(nums, left+1, end);
}


public static void quickSort(int[] nums) {
	if(nums.length < 2) return;
	quickSort(nums, 0, nums.length-1);
}

//no duplicates
private static void quickSort(int[] nums, int start, int end) {
	if(start >= end) return;
	int pivot = nums[end];
	int left = start, right = end-1;
	while(left <= right) {
		while(left <= right && nums[left] < pivot) left++;
		while(left <= right && nums[right] > pivot) right--;
		if(left < right) swap(nums, left, right);
	} 
	swap(nums, left, end);
	quickSort(nums, start, left-1);
	quickSort(nums, left+1, end);
}

//allow duplicates
private static void quickSort(int[] nums, int start, int end) {
	if(start >= end) return;
	pivot = nums[end];
	int left = start, right = end;
	for(int cur = start; cur <= right; cur++) {
		if(nums[cur] < pivot) {
			swap(nums, left, cur);
			left++;
		} else if(nums[cur] > pivot) {
			swap(nums, cur, right);
			right--;
			cur--;
		}
	}
	quickSort(nums, start, left-1);
	quickSort(nums, right+1, end);
}

private static void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}













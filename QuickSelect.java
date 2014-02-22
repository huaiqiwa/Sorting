private static Random random = new Random();

public static int quickSelect(int[] nums, int k) {
	return quickSelect(nums, k, 0, nums.length-1);
}

private static int quickSelect(int[] nums, int k, int start, int end) {
	int len = end-start+1;
	int ipivot = start + random.nextInt(len);
	int pivot = nums[ipivot];
	swap(nums, ipivot, end);
	int left = start, right = end-1;
	while(left <= right) {
		while(left <= right && nums[left] <= pivot) left++;
		while(left <= right && nums[right] > pivot) right--;
		if(left < right) swap(nums, left, right);
	}
	swap(nums, left, end);
	if(left+1 == k) return pivot;
	else if(left+1 > k) return quickSelect(nums, k, start, left-1);
	else return quickSelect(nums, k-left-1, left+1, end);
}

//handle duplicates optimization
private static int quickSelect(int[] nums, int k, int start, int end) {
	int len = end-start+1;
	int ipivot = start + random.nextInt(len);
	int pivot = nums[ipivot];
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
	left--; right++;
	if(k <= left+1) return quickSelect(nums, k, start, left);
	else if(k <= right) return pivot;
	else return quickSelect(nums, k-right, right, end);
}

private static void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}


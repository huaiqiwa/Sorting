//nums range from 0 to range-1
public void countSort(int[] nums, int range) {
	int[] count = new int[range];
	int[] helper = new int[nums.length];
	for(int i = 0; i < nums.length; i++) {
		count[nums[i]]++;
	}
	for(int i = 1; i < range; i++) {
		count[i] += count[i-1];
	}
	for(int i = 0; i < nums.length; i++) {
		count[nums[i]]--;
		helper[count[nums[i]]] = nums[i];
	}
	for(int i = 0; i < nums.length; i++) {
		nums[i] = helper[i];
	}
}

public void bucketSort(int[] nums) {
	int len = nums.length;
	if(len == 0) return;
	int min = nums[0], max = nums[0];
	for(int i = 1; i < len; i++) {
		if(nums[i] > max) max = nums[i];
		if(nums[i] < min) min = nums[i];
	}
	int[] count = new int[max-min+1];
	for(int i = 0; i < len; i++) {
		count[nums[i]-min]++;
	}
	for(int i = 0, index = 0; i < count.length; i++) {
		for(int j = 0; j < count[i]; j++) {
			count[index] = min+i;
			index++;
		}
	}
}


public void radixSort(int[] nums, int maxDigits) {
	ArrayList<Integer>[] buckets = (ArrayList<Integer>[])new ArrayList[10];
	for(int i = 0; i < 10; i++) {
		buckets[i] = new ArrayList<Integer>();
	}
	int exp = 1;
	for(int i = 0; i < maxDigits; i++) {
		for(int j = 0; i != 0 && j < 10; j++) {
			buckets[j].clear();
		}
		for(int j = 0; j < nums.length; j++) {
			buckets[(nums[j]/exp) % 10].add(nums[j]);
		}
		for(int j = 0, index = 0; j < 10; j++) {
			for(int num : buckets[j]) {
				nums[index] = num;
				index++;
			}
		}
		exp *= 10;
	}
}


public void radixSort(int[] nums) {
	LinkedList<Integer>[] buckets = (LinkedList<Integer>[])new LinkedList[10];
	for(int i = 0; i < 10; i++) {
		bucket[i] = new LinkedList<Integer>();
	}
	int divisor = 1;
	boolean hasNonZeroDigit = true;
	while(hasNonZeroDigit) {
		hasNonZeroDigit = false;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]/divisor > 0) hasNonZeroDigit = true;
			buckets[(nums[i]/divisor) % 10].add(nums[i]);
		}
		for(int i = 0, index = 0; i < 10; i++) {
			while(!bucket[i].isEmpty()) {
				nums[index] = bucket[i].removeFirst();
				index++;
			}
		}
		divisor *= 10;
	}
}





























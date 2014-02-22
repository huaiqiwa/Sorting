import java.util.ArrayList;

public class HeapMinPriorityQueue<E extends Comparable<E>> implements MinPriorityQueue<E> {
	private ArrayList<E> heap;
	
	public HeapMinPriorityQueue() {
		heap = new ArrayList<E>();
	}
	
	public E extractMin() {
		if(heap.size() == 0) return null;
		else {
			E minVal = heap.get(0);
			heap.set(0, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			minHeapify(heap, 0);
			return minVal;
		}
	}
	
	public void insert(E element) {
		heap.add(element);
		int loc = heap.size()-1;
		while(loc > 0 && heap.get(loc).compareTo(heap.get(parent(loc))) < 0) {
			swap(heap, loc, parent(loc));
			loc = parent(loc);
		}
	}
	
	public boolean isEmpty() {
		return heap.size() == 0;
	}
	
	public E minimun() {
		if(heap.size() == 0) return null;
		else return heap.get(0);
	}
	
	private static <E extends Comparable<E>> void minHeapify(ArrayList<E> heap, int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int smallest = i;
		if(left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) 
			smallest = left;
		if(right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) 
			smallest = right;
		if(smallest != i) {
			swap(heap, i, smallest);
			minHeapify(heap, smallest);
		}
	}
	
	private static <E> void swap(ArrayList<E> heap, int i, int j) {
		E e = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, e);
	}
	
	private static int leftChild(int i) {
		return 2*i + 1;
	}
	
	private static int rightChild(int i) {
		return 2*i + 2;
	}
	
	private static int parent(int i) {
		return (i-1) / 2;
	}
}





















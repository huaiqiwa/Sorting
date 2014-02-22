private static void toposort(ArrayList<ArrayList<Integer>> graph, int[] indegs) {
	int n = indegs.length;
	boolean[] visited = new boolean[n];
	Queue<Integer> que = new PriorityQueue<Integer>();
	ArrayList<Integer> res = new ArrayList<Integer>(n);
	
	for(int i = 0; i < n; i++) {
		if(indegs[i] == 0) que.offer(i);
	}
	while(!que.isEmpty()) {
		int node = que.poll();
		res.add(node+1);
		visited[node] = true;
		for(int n : graph.get(node)) {
			if(visited[n]) break;
			indegs[n]--;
			if(indegs[n] == 0) que.offer(n);
		}
	}
	
	if(res.size() < n) System.out.println("Sandro fails.");
	else System.out.println(res);
}

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt(), m = in.nextInt();
	
	ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	int[] indegs = new int[n];
	for(int i = 0; i < n; i++) {
		graph.add(new ArrayList<Integer>(n));
	}
	
	for(int i = 0; i < m; i++) {
		int v1 = in.nextInt()-1, v2 = in.nextInt()-1;
		graph.get(v1).add(v2);
		indegs[v2]++;
	}
	
	toposort(graph, indegs);
}




















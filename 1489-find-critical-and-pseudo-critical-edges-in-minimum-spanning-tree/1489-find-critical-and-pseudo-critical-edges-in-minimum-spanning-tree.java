class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n){
        this.rank = new int[n];
		Arrays.fill(this.rank, 1);
        this.parent = new int[n];
        for(int i = 0; i < n; i++){
            this.parent[i] = i;
        }
    }

    public int findParent(int node){
        if(this.parent[node] == node){
            return node;
        }
        return this.parent[node] = findParent(this.parent[node]);
    }

    public boolean unionByRank(int node1, int node2){
        int pNode1 = findParent(node1);
        int pNode2 = findParent(node2);
        if(pNode1 == pNode2){
            return false;
        }
        if(this.rank[pNode1] < this.rank[pNode2]){
            this.parent[pNode1] = pNode2;
            this.rank[pNode2] += this.rank[pNode1];
        }
        else{
            this.parent[pNode2] = pNode1;
            this.rank[pNode1] += this.rank[pNode2];
        }
        return true;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adjList.add(i, Arrays.asList(edges[i][0], edges[i][1], edges[i][2], i));
        }
        Collections.sort(adjList, (val1, val2) -> Integer.compare(val1.get(2), val2.get(2)));
        
        int mstWeight = 0;
		UnionFind uf = new UnionFind(n);
		for(List<Integer> l : adjList){
            if(uf.unionByRank(l.get(0), l.get(1))){
                mstWeight += l.get(2);
            }
        }
		for(List<Integer> l : adjList){
			int weight = 0;
			UnionFind uf1 = new UnionFind(n);
			for(List<Integer> l1 : adjList){
				if(l.get(3) != l1.get(3) && uf1.unionByRank(l1.get(0), l1.get(1))){
					System.out.println(l.get(3) + "!=" + l1.get(3));
					weight += l1.get(2);
                }
			}				
			if(Arrays.stream(uf1.rank).max().getAsInt() != n || mstWeight < weight){
				critical.add(l.get(3));
				continue;
			}
			
			UnionFind uf2 = new UnionFind(n);
			uf2.unionByRank(l.get(0), l.get(1));
			weight = l.get(2);
			for(List<Integer> l2 : adjList){
				if(uf2.unionByRank(l2.get(0), l2.get(1))){
					weight += l2.get(2);
                }
            }
			if(mstWeight == weight){
				pseudoCritical.add(l.get(3));
			}
		}
        return Arrays.asList(critical, pseudoCritical);
    }
}
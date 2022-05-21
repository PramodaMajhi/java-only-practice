package DisjointSets;

public class QuickFind {
    int [] parent;
    QuickFind(int N){
         parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i; // set parent of each object to itself
                            // (N array access)
        }
    }
/*
Check whether p and q are in the same component of (2 array access)
 */
    public boolean connect(int p, int q) {
        return parent[p] == parent[q];
    }

    public void union(int p, int q) {
        int pid = parent[p];
        int qid = parent[q];
        // Change all entries with parent[p] to parent[q]
        // (at most 2N + 2 array accesses)
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == pid){
                parent[i] = qid;
            }
        }
    }
}

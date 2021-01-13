public class LeetCode684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        int[] rank = new int[edges.length];
        for(int i = 0; i < edges.length; i++){
            parent[i] = -1;
            rank[i] = -1;
        }

        for(int[] i : edges){
            int x = i[0];
            int y = i[1];
            if(!unionVertice(x, y, parent, rank)) {
                return i;
            }
        }

        int[] i = {0, 0};
        return i;
    }

    public int findRoot(int vertice, int[] parent) {
        int verticeRoot = vertice - 1;
        while(parent[verticeRoot] != -1){
            verticeRoot = parent[verticeRoot];
        }
        return verticeRoot;
    }

    public boolean unionVertice(int x, int y, int[] parent, int[] rank) {
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if(xRoot == yRoot) {
            return false;
            //产生环
        }else {
            if(rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            }else if(rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            }else {
                parent[xRoot] = yRoot;
                rank[xRoot]++;
            }
            return true;
        }
    }

}

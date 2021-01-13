import java.util.Arrays;

public class DisjointSet {
    /**
     * 并查集
     */
    public int findRoot(int vertical, int[] parent) {
        int verticalRoot = vertical - 1;
        while(parent[verticalRoot] != -1){
            verticalRoot = parent[verticalRoot];
        }
        return verticalRoot;
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

    public static void main(String[] args){
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] parent = {-1, -1, -1};
        int[] rank = {0, 0, 0};
        DisjointSet disjointSet = new DisjointSet();
        for(int[] i :edges){
            int x = i[0];
            int y = i[1];
            if(!disjointSet.unionVertice(x,y,parent,rank)) {
                System.out.println(Arrays.toString(i));
            }
        }
    }

}

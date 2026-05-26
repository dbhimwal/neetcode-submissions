class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        int components = 0;
        for (int i = 0; i < n; i++) {
            if(!visit.contains(i)) {
                dfs(i, visit, adj);
                components++;
            }
        }
        return components;
    }

    private void dfs(int node, Set<Integer> visit,
                        List<List<Integer>> adj) {
        
        if(visit.contains(node)) {
            return;
        }
        visit.add(node);
        for (int nei : adj.get(node)) {
            dfs(nei, visit, adj);
        }
        return;
    }
}

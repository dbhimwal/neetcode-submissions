class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> connections = new HashMap<>();
        tickets.sort((a, b) -> (a.get(1).compareTo(b.get(1))));
        for(List<String> ticket : tickets) {
            if(!connections.containsKey(ticket.get(0))) {
                connections.put(ticket.get(0), new ArrayList<>());
            }
            connections.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        if(dfs("JFK", result, connections, tickets.size())) {
            return result;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String source, List<String> result, Map<String, List<String>> connections, int size) {
        if(result.size() > size) {
            return true;
        }

        if(!connections.containsKey(source)) {
            return false;
        }

        for(int i = 0; i < connections.get(source).size(); i++) {
            String destination = connections.get(source).get(i);
            connections.get(source).remove(i);
            result.add(destination);
            if(dfs(destination, result, connections, size)) {
                return true;
            }
            connections.get(source).add(i, destination);
            result.remove(result.size() - 1);
        }
        return false;
    }
}

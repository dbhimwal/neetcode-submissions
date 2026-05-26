class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> connected = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length - 1; j++) {
                for(int k = j + 1; k < routes[i].length; k++) {
                    if (connected.containsKey(routes[i][j])) {
                        connected.get(routes[i][j]).add(routes[i][k]);
                    } else {
                        Set<Integer> temp = new HashSet<>();
                        temp.add(routes[i][k]);
                        connected.put(routes[i][j], temp);
                    }
                    if (connected.containsKey(routes[i][k])) {
                        connected.get(routes[i][k]).add(routes[i][j]);
                    } else {
                        Set<Integer> temp = new HashSet<>();
                        temp.add(routes[i][j]);
                        connected.put(routes[i][k], temp);
                    }
                }
            }
        }

        // System.out.println(connected);

        Queue<Integer> reached = new ArrayDeque<>();
        reached.add(source);
        visited.add(source);
        int distance = 0;

        while(!reached.isEmpty()) {
            Queue<Integer> nextStops = new ArrayDeque<>();
            while(!reached.isEmpty()) {
                Integer stop = reached.poll();
                if(stop == target) {
                    return distance;
                }
                if(connected.containsKey(stop)) {
                    for (int next : connected.get(stop)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            nextStops.add(next);
                        }
                    }
                }
            }
            distance++;
            reached = nextStops;
        }

        return -1;
    }
}
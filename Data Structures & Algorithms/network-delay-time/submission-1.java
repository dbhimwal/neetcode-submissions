class Solution {
    class Path {
        int destination, delay;
        
        public Path(int target, int time) {
            destination = target;
            delay = time;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Path>> routes = new HashMap<>();
        for(int i = 0; i < n; i++) {
            routes.put(i, new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++) {
            routes.get(times[i][0] - 1).add(new Path(times[i][1] - 1, times[i][2]));
        }
        
        int[] duration = new int[n];
        Arrays.fill(duration, Integer.MAX_VALUE);

        PriorityQueue<Path> toExplore = new PriorityQueue<>((a, b) -> (a.delay - b.delay));
        toExplore.add(new Path(k - 1, 0));
        duration[k - 1] = 0;

        while(!toExplore.isEmpty()) {
            Path current = toExplore.poll();
            if(current.delay > duration[current.destination]) {
                continue;
            }
            List<Path> adjacents = routes.get(current.destination);
            for(int i = 0; i < adjacents.size(); i++) {
                if(current.delay + adjacents.get(i).delay < duration[adjacents.get(i).destination]) {
                    duration[adjacents.get(i).destination] = adjacents.get(i).delay + current.delay;
                    toExplore.add(new Path(adjacents.get(i).destination, adjacents.get(i).delay + current.delay));
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, duration[i]);
        }

        if(max == Integer.MAX_VALUE) {
            return -1;
        }
        return max;
    }
}

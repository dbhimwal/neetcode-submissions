class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prereq = new ArrayList<>();
        List<Integer> prereqCount = new ArrayList<>();
        Queue<Integer> planningCourse = new LinkedList<>();
        int[] result = new int[numCourses];
        int couseCompleted = 0;
        int index = 0;

        for(int i = 0; i < numCourses; i++) {
            prereq.add(new ArrayList<>());
            prereqCount.add(0);
        }

        for(int i = 0; i < prerequisites.length; i++) {
            prereq.get(prerequisites[i][1]).add(prerequisites[i][0]);
            prereqCount.set(prerequisites[i][0], prereqCount.get(prerequisites[i][0])+1);
        }

        System.out.println(prereqCount);

        for(int i = 0; i < numCourses; i++) {
            if(prereqCount.get(i) == 0) {
                planningCourse.add(i);
            }
        }

        while(!planningCourse.isEmpty()) {
            int nextCourse = planningCourse.poll();
            result[index++] = nextCourse;
                
            for(int c : prereq.get(nextCourse)) {
                prereqCount.set(c, prereqCount.get(c) - 1);
                if(prereqCount.get(c) == 0) {
                    planningCourse.add(c);
                }
            }
        }

        if(index == numCourses) {
            return result;
        }
        else {
            return new int[0];
        }
    }
}

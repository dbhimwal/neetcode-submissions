class Solution {
        private Map<Integer, List<Integer>> prereq = new HashMap<>();
        private Set<Integer> planningCourse = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            prereq.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!canCoverCourse(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean canCoverCourse(int course) {
        if(planningCourse.contains(course)) {
            return false;
        }
        if(prereq.get(course).isEmpty()) {
            return true;
        }

        planningCourse.add(course);
        for(int pre : prereq.get(course)) {
            if(!canCoverCourse(pre)) {
                return false;
            }
        }
        planningCourse.remove(course);
        // prereq.put(course, new ArrayList<>());
        return true;
    }
}

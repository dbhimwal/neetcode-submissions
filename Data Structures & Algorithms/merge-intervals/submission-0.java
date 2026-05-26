class Solution {
    private class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval b) {
            return this.start - b.start;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        List<Interval> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList);

        Interval previousInterval = null;

        for(Interval interval : intervalList) {
            if(previousInterval == null) {
                previousInterval = interval;
            } else {
                if(previousInterval.end >= interval.start) {
                    previousInterval.end = Math.max(previousInterval.end, interval.end);
                } else {
                    result.add(previousInterval);
                    previousInterval = interval;
                }
            }
        }

        if(previousInterval != null) {
            result.add(previousInterval);
        }

        int[][] response = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            response[i][0] = result.get(i).start;
            response[i][1] = result.get(i).end;
        }
        return response;
    }
}

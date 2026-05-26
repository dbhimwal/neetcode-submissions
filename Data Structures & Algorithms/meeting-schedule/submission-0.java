/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start -  b.start;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        int previousEnd = -1;

        for(Interval current : intervals) {
            if(current.start < previousEnd) {
                return false;
            }
            previousEnd = current.end;
        }
        return true;
    }
}

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
    private class Time implements Comparable<Time> {
        boolean isStart;
        int time;

        Time(int time, boolean isStart) {
            this.isStart = isStart;
            this.time = time;
        }

        @Override
        public int compareTo(Time other) {
            int returnValue = this.time - other.time;
            if(returnValue == 0) {
                if(!this.isStart) {
                    return -1;
                }
            }
            return returnValue;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        List<Time> timeCollection = new ArrayList<>();

        for(Interval current : intervals) {
            timeCollection.add(new Time(current.start, true));
            timeCollection.add(new Time(current.end, false));
        }

        Collections.sort(timeCollection);

        int maxRooms = 0;
        int currentRooms = 0;

        for(Time currentime : timeCollection) {
            if(currentime.isStart) {
                currentRooms++;
            } else {
                maxRooms = Math.max(maxRooms, currentRooms);
                currentRooms--;
            }
        }

        return maxRooms;
    }
}

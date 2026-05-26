class Solution {
    public class Area {
        Map<Integer, Integer> includingCurrent;
        Integer maxNotincludingCurrent;

        public Area(int max, Map<Integer, Integer> possibleAreas) {
            includingCurrent = possibleAreas;
            maxNotincludingCurrent = max;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Area> areas = new Stack<>();
        int currentMax = 0;
        Map<Integer, Integer> firstArea = new HashMap();
        firstArea.put(heights[0], 1);
        System.out.println(currentMax);
        System.out.println(firstArea.toString());
        areas.push(new Area(currentMax, firstArea));
        int overallMax = heights[0];

        for(int i = 1; i < heights.length; i++) {
            Map<Integer, Integer> current = new HashMap<>();
            int maxWidth = 0;
            boolean covered = false;
            Area previousArea = areas.pop();
            currentMax = previousArea.maxNotincludingCurrent;
            for(Map.Entry<Integer, Integer> possibleArea : previousArea.includingCurrent.entrySet()) {
                int height = possibleArea.getKey();
                if(height > heights[i]) {
                    currentMax = Math.max(currentMax, height * possibleArea.getValue());
                    overallMax = Math.max(overallMax, currentMax);
                    maxWidth = Math.max(maxWidth, possibleArea.getValue());
                } else {
                    current.put(height, possibleArea.getValue() + 1);
                    if(height == heights[i]) {
                        covered = true;
                    }
                }
            }
            if(!covered) {
                current.put(heights[i], maxWidth + 1);
            }
            System.out.println(currentMax);
            System.out.println(current.toString());
            areas.push(new Area(currentMax, current));
        }
        for(Map.Entry<Integer, Integer> possibleArea : areas.pop().includingCurrent.entrySet()) {
            overallMax = Math.max(overallMax, possibleArea.getKey() * possibleArea.getValue());
        }
        return overallMax;
    }
}

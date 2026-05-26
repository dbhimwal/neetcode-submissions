class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> finalPoints = new PriorityQueue<>(Comparator.comparingDouble(a -> 1/(Math.pow(a[0], 2) + Math.pow(a[1], 2))));

        for(int i = 0; i < points.length; i++) {
            if(finalPoints.size() < k) {
                finalPoints.add(points[i]);
                continue;
            }
            int[] furthestPoint = finalPoints.peek();
            int furthestPointDistance = (int) (Math.pow(furthestPoint[0], 2) + Math.pow(furthestPoint[1], 2));
            int pointDistance = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            System.out.println(furthestPoint[0] +"," + furthestPoint[1] + "=" + furthestPointDistance);
            System.out.println(pointDistance);
            if (furthestPointDistance > pointDistance) {
                finalPoints.poll();
                finalPoints.add(points[i]);
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!finalPoints.isEmpty()) {
            result[i] = finalPoints.poll();
            i++;
        }
        return result;
    }
}

class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> oceanViewBuilding = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            while(!oceanViewBuilding.isEmpty() && heights[oceanViewBuilding.peek()] <= heights[i]) {
                oceanViewBuilding.pop();
            }
            oceanViewBuilding.push(i);
        }
        System.out.println(oceanViewBuilding);
        int[] result = new int[oceanViewBuilding.size()];
        for(int i = oceanViewBuilding.size(); i > 0; i--) {
            result[oceanViewBuilding.size() - 1] = oceanViewBuilding.pop();
        }
        return result;

    }
}
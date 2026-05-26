class Solution {
    public static class TempIndex {
        int index;
        int temp;

        public TempIndex(int idx, int temperature) {
            index = idx;
            temp = temperature;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<TempIndex> maxTemp = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            if(maxTemp.isEmpty()) {
                result[i] = 0;
                maxTemp.push(new TempIndex(i, temperatures[i]));
            } else {
                while(!maxTemp.empty()) {
                    if(maxTemp.peek().temp <= temperatures[i]) {
                        maxTemp.pop();
                    } else {
                        result[i] = maxTemp.peek().index - i;
                        maxTemp.push(new TempIndex(i, temperatures[i]));
                        break;
                    }
                }
                if(maxTemp.empty()) {
                    result[i] = 0;
                    maxTemp.push(new TempIndex(i, temperatures[i]));
                }
            }
        }
        return result;
    }
}

class Solution {
    private static class NumberFreq {
        int num;
        int frequency;

        NumberFreq(int n, int freq) {
            num = n;
            frequency = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, NumberFreq> frequencies = new HashMap<>();
        PriorityQueue<NumberFreq> min_heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));

        for(int i = 0; i < nums.length; i++) {
            NumberFreq nf;
            if(frequencies.containsKey(nums[i])) {
                nf = frequencies.get(nums[i]);
                nf.frequency += 1;
            } else {
                nf = new NumberFreq(nums[i], 1);
                frequencies.put(nums[i],nf);
            }
        }

        for (Map.Entry<Integer, NumberFreq>frequency : frequencies.entrySet()) {
            NumberFreq nf = frequency.getValue();
            if(min_heap.size() < k) {
                min_heap.add(nf);
            } else {
                NumberFreq min_freq_num = min_heap.peek();
                if(min_freq_num.frequency < nf.frequency) {
                    min_heap.poll();
                    min_heap.add(nf);
                }
            }
        }
        int[] result = new int[k];
        int i = 0;
        while(!min_heap.isEmpty()) {
            result[i] = min_heap.poll().num;
            i++;
        }

        return result;
    }
}

class Solution {
    class Task {
        char task;
        int count;
        int lastScheduled = -1;

        Task(char t, int c) {
            task = t;
            count = c;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskcount = new HashMap<>();
        PriorityQueue<Task> processingTask = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        Queue<Task> collingTask = new ArrayDeque<>();

        for(int i = 0; i < tasks.length; i++) {
            taskcount.put(tasks[i], taskcount.getOrDefault(tasks[i], 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> task : taskcount.entrySet()) {
            processingTask.add(new Task(task.getKey(), task.getValue()));
        }
        int cpu_cycle = 1;

        while(!processingTask.isEmpty() || !collingTask.isEmpty()) {
            if(!collingTask.isEmpty()) {
                Task t = collingTask.peek();
                if(cpu_cycle - t.lastScheduled > n) {
                    processingTask.add(collingTask.poll());
                }
            }
            if(!processingTask.isEmpty()) {
                Task currentTask = processingTask.poll();
                if(currentTask.count > 1) {
                    currentTask.count = currentTask.count - 1;
                    currentTask.lastScheduled = cpu_cycle;
                    collingTask.add(currentTask);
                }
                System.out.println(cpu_cycle + "-" + currentTask.task);
                cpu_cycle++;
            } else if (!collingTask.isEmpty()){
                cpu_cycle = n + collingTask.peek().lastScheduled + 1;
            }
        }
        return cpu_cycle - 1;
    }
}

//Question No: 21773
//Title: 가희와 프로세스 1
//Tier: Gold V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Task implements Comparable<Task>{
        int id;
        int remainingTime;
        int currentPriority;

        public Task(int id, int remainingTime, int currentPriority){
            this.id =id;
            this.remainingTime = remainingTime;
            this.currentPriority = currentPriority;
        }

        @Override
        public int compareTo(Task task){
            int comparison = task.currentPriority - this.currentPriority;
            if(comparison == 0) comparison = this.id - task.id;
            return comparison;
        }
    }

    public static int totalTime, taskCount;
    public static PriorityQueue<Task> taskQueue;
    public static void input() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        totalTime = Integer.parseInt(tokenizer.nextToken());
        taskCount = Integer.parseInt(tokenizer.nextToken());
        taskQueue = new PriorityQueue<Task>();
        for(int i = 0; i < taskCount; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            taskQueue.offer(new Task(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }
    }

    public static void main(String[] args) throws Exception{
        input();

        StringBuilder resultBuilder = new StringBuilder();
        int currentTime = 0;
        while(!taskQueue.isEmpty()){
            if(++currentTime > totalTime) break;
            Task task = taskQueue.poll();
            resultBuilder.append(task.id + "\n");
            task.remainingTime--;
            task.currentPriority--;
            if(task.remainingTime > 0) taskQueue.offer(task);
        }
        System.out.println(resultBuilder.toString());
    }
}
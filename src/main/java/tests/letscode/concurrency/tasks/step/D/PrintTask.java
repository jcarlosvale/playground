package tests.letscode.concurrency.tasks.step.D;

import java.util.Random;

public class PrintTask  implements Runnable{
   private static final int MAX_RANDOM = 1500;
   private final String taskName;
   private final Random random = new Random();
   private final int sleepTime;

   // constructor
   public PrintTask(final int taskId) {
      this.sleepTime = random.nextInt(MAX_RANDOM);
      this.taskName = "task_"+ taskId;
      System.out.printf("Task %s - sleep %d %n", taskName, sleepTime);
   }

   // print task name
   public void print() throws InterruptedException {
      System.out.printf("Tarefa %s sleeping...%n", taskName);
      Thread.sleep(sleepTime);
      System.out.printf("Tarefa %s impressa%n", taskName);
   }

   @Override
   public void run() {
      try {
         print();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
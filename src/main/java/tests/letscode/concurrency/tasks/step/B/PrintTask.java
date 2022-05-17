package tests.letscode.concurrency.tasks.step.B;

public class PrintTask  implements Runnable{
   private final String taskName;

   // constructor
   public PrintTask(final int taskId) {
      this.taskName = "task_"+ taskId;
   }

   // print task name
   public void print() {
      System.out.printf("Tarefa %s impressa%n", taskName);
   }

   @Override
   public void run() {
      print();
   }
}
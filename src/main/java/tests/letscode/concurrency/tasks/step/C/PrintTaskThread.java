package tests.letscode.concurrency.tasks.step.C;

public class PrintTaskThread extends Thread{
   private final String taskName;

   // constructor
   public PrintTaskThread(final int taskId) {
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
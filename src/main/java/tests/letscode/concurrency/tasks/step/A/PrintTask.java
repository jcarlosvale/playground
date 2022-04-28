package tests.letscode.concurrency.tasks.step.A;

public class PrintTask  {
   private final String taskName;
    
   // constructor
   public PrintTask(final int taskId) {
      this.taskName = "task_"+ taskId;
   }

   // print task name
   public void print() {
      System.out.printf("Tarefa %s impressa%n", taskName);
   }
}
package tests.letscode.concurrency.tasks.step.C;

public class PrintTaskLambda {
   private final String taskName;

   // constructor
   public PrintTaskLambda(final int taskId) {
      this.taskName = "task_"+ taskId;
   }

   // print task name
   public void print() {
      System.out.printf("Tarefa %s impressa%n", taskName);
   }
}
#Concurrency

## Threads

* all operating systems support what is known as **multithreaded processing**.
  * **multithreaded processing** is to allow an application or group of applications to execute _multiple tasks at the same time_.

* A **thread** is the smallest unit of execution that can be scheduled by the operating system.

* A **process** is a _group of associated threads_ that execute in the same _shared environment_.
  * a _single-threaded process_ is one that contains exactly one thread
  * _multithreaded_ process supports more than one thread

* **shared environment**
  * threads in the same process share the same memory space and can communicate directly with one another.

### Concurrency

* **concurrency** is the property of executing multiple threads and processes at the same time
* Operating systems use a thread scheduler to determine which threads
  should be currently executing;
  * applying round-robin schedule, fifo, priority based scheduler, ...
* A context switch is the process of storing a thread’s current state and later restoring the state of the thread to continue execution.
* A thread can interrupt or supersede another thread if it has a higher thread priority than the other thread.
  * A thread priority is a numeric value associated with a thread that is taken into consideration by the thread scheduler when determining which threads should currently be executing.

### Creating Threads

* to define a task for a thread is by using the [Runnable](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Runnable.html) functional interface
 
```java
@FunctionalInterface 
public interface Runnable {
void run();
}
```

* you need to instantiate a _[Thread](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html)_ and call the method **_start()_**
```java
public class PrimeiraThread {

    public static void main(String[] args) {
        new Thread(() -> System.out.print(" Ola ")).start();
        System.out.print(" Mundo ");
    }
}
```

* Remember that order of  thread execution is not often guaranteed.
  * "Ola Mundo"
  * "Mundo Ola"

```java
 Mundo  Ola
```

```java
public class MultiplasThreads {

    public static void main(String[] args) {
        Runnable imprimirCatalogo = () -> System.out.println("Imprimindo catalogo");
        Runnable imprimirRegistros = () -> {
            for (int i = 0; i < 4; i++)
                System.out.println("Imprimindo registro: " + i);
        };

        System.out.println("inicio");
        new Thread(imprimirCatalogo).start();
        new Thread(imprimirRegistros).start();
        new Thread(imprimirCatalogo).start();
        System.out.println("fim");
    }
}
```

* we have 4 threads

```java
inicio
fim
Imprimindo catalogo
Imprimindo catalogo
Imprimindo registro: 0
Imprimindo registro: 1
Imprimindo registro: 2
Imprimindo registro: 3
```

* Each thread is executed as an asynchronous task.
  * asynchronous, we mean that the thread executing the main() method does not wait for the results of each newly created thread before continuing
  * The opposite of this behavior is a synchronous task in which the program waits

### Types of Threads

* A **_system thread_** is created by the Java Virtual Machine (JVM) and runs in the background of the application.
* a **_user-defined thread_** is one created by the application developer to accomplish a specific task.
  * main() method is an example, _single-threaded application_
* System and user-defined threads can both be created as daemon threads
  * A **_daemon_** thread is one that will not prevent the JVM from exiting when the program finishes.
  * method _setDaemon()_

```java
public class ThreadComPause {

    public static void pause() {
        try {
            Thread.sleep(2_000); // pausar por 2 segundos
        } catch (InterruptedException e) {}
        System.out.println("Thread finalizada");
    }

    public static void main(String[] unused) {
        var tarefa = new Thread(() -> pause()); // Cria thread

        tarefa.start(); // Inicia thread
        System.out.println("Fim do programa!");
    }
}
```

```java
Fim do programa!
Thread finalizada
```

* method _daemon()_

```java
public class ThreadDaemonComPause {

    public static void pause() {
        try {
            Thread.sleep(2_000); // pausar por 2 segundos
        } catch (InterruptedException e) {}
        System.out.println("Thread finalizada");
    }

    public static void main(String[] unused) {
        var tarefa = new Thread(() -> pause()); // Cria thread
        tarefa.setDaemon(true); //Thread daemon
        tarefa.start(); // Inicia thread
        System.out.println("Fim do programa!");
    }
}
```

```java
Fim do programa!
```

### Thread's Life Cycle

* method _getState()_ implies one of these [states](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.State.html):
  * NEW
    * when we instantiate a thread;
  * RUNNABLE
    * when we call the _start()_ method
    * not necessarily is running
  * BLOCKED
    * when the thread wait to access a synchronized block or resource
  * WAITING
    * when the thread is waiting a signal of other thread
  * TIMED_WAITING
    * when we use the _sleep()_ method
  * TERMINATED
    * when the thread has executed your task, it is not possible to re-run the same thread

![thread_states](img/states_thread.png)

### Pooling with Sleep
* _Polling_ is the process of intermittently checking data at some fixed interval.
* method _sleep()_ transition _RUNNABLE_ and _TIMED_WAITING_ 

```java
public class EnviarMensagemComSleep {

    private static boolean mensagemEnviada = false;

    public static void main(String[] a) {

        new Thread(() -> {
            try {
                Thread.sleep(2000); //2 segundos
                mensagemEnviada = true;
            } catch (InterruptedException e) {
                System.out.println("thread Interrompida!");
            }
        }).start();

        while (!mensagemEnviada) {
            System.out.println("Enviando mensagem...");
            try {
                Thread.sleep(500); // 500 milissegundos
            } catch (InterruptedException e) {
                System.out.println("main interrompido!");
            }
        }
        System.out.println("Mensagem enviada!!");
    }
}
```
```java
Enviando mensagem...
Enviando mensagem...
Enviando mensagem...
Enviando mensagem...
Mensagem enviada!!
```

### Interrupting a Thread

* method _interrupt()_
  * Calling interrupt() on a thread in the TIMED_WAITING or WAITING state causes the main() thread to become RUNNABLE again, triggering an InterruptedException.

```java
public class EnviarMensagemComInterrupt {

    private static boolean mensagemEnviada = false;

    public static void main(String[] a) {

        final var mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                Thread.sleep(2000); //2 segundos
                mensagemEnviada = true;
                mainThread.interrupt();
            } catch (InterruptedException e) {
                System.out.println("thread Interrompida!");
            }
        }).start();

        while (!mensagemEnviada) {
            System.out.println("Enviando mensagem...");
            try {
                Thread.sleep(5000); // 5 segundos
            } catch (InterruptedException e) {
                System.out.println("main interrompido!");
            }
        }
        System.out.println("Mensagem enviada!!");
    }
}
```

```java
Enviando mensagem...
main interrompido!
Mensagem enviada!!
```

## The Concurrency API

* [java.util.concurrent](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/package-summary.html) package
  * [ExecutorService](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ExecutorService.html) interface, which defines services that create and manage threads.

### Single-Thread Executor

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplasThreadsComExecutorService {

  public static void main(String[] args) {
    Runnable imprimirCatalogo = () -> System.out.println("Imprimindo catalogo");
    Runnable imprimirRegistros = () -> {
      for (int i = 0; i < 4; i++)
        System.out.println("Imprimindo registro: " + i);
    };

    ExecutorService service = Executors.newSingleThreadExecutor();
    try {
      System.out.println("inicio");
      service.execute(imprimirCatalogo);
      service.execute(imprimirRegistros);
      service.execute(imprimirCatalogo);
      System.out.println("fim");

    } finally {
      service.shutdown();
    }
  }
}
```

```java
inicio
fim
Imprimindo catalogo
Imprimindo registro: 0
Imprimindo registro: 1
Imprimindo registro: 2
Imprimindo registro: 3
Imprimindo catalogo
```

```java
ExecutorService service = Executors.newSingleThreadExecutor();
try {
    System.out.println("inicio");
    service.execute(imprimirCatalogo);
    service.execute(imprimirRegistros);
    service.execute(imprimirCatalogo);
    System.out.println("fim");

} finally {
    service.shutdown();
}
```

* _newSingleThreadExecutor()_ method to create the service.
  * instead of 4 threads we have 2;
  * tasks are guaranteed to be executed sequentially
* method _execute()_
  * receives a Runnable instance and completes the task asynchronously.
  * void return

### Shutting Downs a Thread Executor

* method _shutdown()_ must be called, the thread executor creates a _non-daemon_ thread.
  * application _never terminating_
* other related methods
  * isShutdown()
    * returns true if shutdown() was executed, new tasks are rejected and executes the previously submitted tasks.
  * isTerminated()
    * returns true when no tasks running and the service rejects new tasks because shutdown() was executed.
* method _shutdownNow()_ is a shutdown() plus try to stop the current task and discard the submitted tasks.

### Submitting Tasks

* method _submit()_ , returns a _[Future](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/Future.html)_ instance.
  * used to return value;
  * used to verify if the task has finished.

|Method name | Description|
|------------|------------|
|void execute(Runnable command) | Executes Runnable task at some point in future. |
|Future<?> submit(Runnable task) | Executes Runnable task at some point in future and returns Future representing task.|
|\<T\> Future\<T\> submit(Callable\<\T\> task) | Executes Callable task at some point in future and returns Future representing pending results of task. |
| \<T\> List\<Future\<T\>\> invokeAll(Collection<? extends Callable\<T\>> tasks) | Executes given tasks and waits for all tasks to complete. Returns List of Future instances in same order in which they were in original collection. |
|\<T\> T invokeAny(Collection<? extends Callable\<T\>> tasks) | Executes given tasks and waits for at least one to complete.|

<figcaption align = "left"><b> Tabela 1: ExecutorService methods </b></figcaption><br>

ExecutorService methods

### Waiting for Results

* the _submit()_ method returns a Future<V> instance that can be used to determine this result.

```java
Future<?> future = service.submit(() -> System.out.println("Primeira thread"));
```

|Method name | Description|
|------------|------------|
|boolean isDone() | Returns true if task was completed, threw exception, or was cancelled.|
|boolean isCancelled() | Returns true if task was cancelled before it completed normally.|
|boolean cancel(boolean mayInterruptIfRunning) | Attempts to cancel execution of task and returns true if it was successfully cancelled or false if it could not be cancelled or is complete. |
| V get() | Retrieves result of task, waiting endlessly if it is not yet available.|
|V get(long timeout, TimeUnit unit)| Retrieves result of task, waiting specified amount of time. If result is not ready by time timeout is reached, checked TimeoutException will be thrown.|

<figcaption align = "left"><b> Tabela 2: Future methods </b></figcaption><br>

```java
import java.util.concurrent.*;

public class EnviarMensagemComFuture {

    private static boolean mensagemEnviada = false;

    public static void main(String[] a) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<?> enviandoMensagem = service.submit(() -> {
            try {
                Thread.sleep(2000); //2 segundos
                mensagemEnviada = true;
            } catch (InterruptedException e) {
                System.out.println("thread Interrompida!");
            }
        });

        try {
            enviandoMensagem.get(5, TimeUnit.SECONDS);
            if (mensagemEnviada) {
                System.out.println("Mensagem enviada!!");
            }
        } catch (TimeoutException e) {
            System.out.println("Tempo expirado");
        } finally {
            service.shutdown();
        }
    }
}
```

* because the method is _void_, the _Future_ in this case returns a _null_
* the method _get()_ from _Future_ can receive an optional [TimeUnit](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/TimeUnit.html) to execute.

#### Callable

* _[Callable](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/Callable.html)_ is a functional interface similar to _Runnable_

```java
@FunctionalInterface
public interface Callable<V> {
  V call() throws Exception;
}
```

```java
import java.util.concurrent.*;

public class Somar {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> somar = service.submit(() -> 14 + 27);
            System.out.println(somar.get()); // 41
        } finally {
            service.shutdown();
        }
    }
}
```

* method _awaitTermination()_, waits a specified time to complete all tasks, returning sooner if all tasks finish or an InterruptedException is detected.

```java
ExecutorService service = Executors.newSingleThreadExecutor();
try {
// várias tarefas são adicionadas ao service
...
} finally {
service.shutdown();
}
service.awaitTermination(1, TimeUnit.MINUTES);
// Check whether all tasks are finished
if(service.isTerminated()) System.out.println("Tarefas executadas!");
else System.out.println("Ainda existe tarefa executando");
```

### Scheduling Tasks

### Increasing Concurrency with Pools

## Writing Thread-Safe Code

### Understanding Thread-Safety

### Accessing Data with volatile

### Protecting Data with Atomic Classes

### Improving Access with synchronized Blocks

### Synchronizing on Methods

package certification.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class AccountInteiros {
    public AtomicInteger balance = new AtomicInteger(0);
}

public class AccountManagerInteiros {

    private AccountInteiros account = new AccountInteiros();

    private void creditar(int valor) {
        System.out.print(account.balance.addAndGet(valor) + " ");
    }

    public static void main(String[] args) {
        final int TASKS = 5;
        ExecutorService service = Executors.newFixedThreadPool(TASKS);
        try {
            var accountManager = new AccountManagerInteiros();
            for(int i = 0; i < TASKS; i++)
                service.submit(() -> accountManager.creditar(1));
        } finally {
            service.shutdown();
        }
    }
}
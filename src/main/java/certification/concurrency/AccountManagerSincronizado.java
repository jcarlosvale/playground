package certification.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AccountSincronizado {
    public double balance = 0;
}

public class AccountManagerSincronizado {

    private AccountSincronizado account = new AccountSincronizado();

    private void creditar(double valor) {
        synchronized (this) {
            account.balance += valor;
            System.out.print((account.balance)+" ");
        }
    }

    public static void main(String[] args) {
        final int TASKS = 5;
        ExecutorService service = Executors.newFixedThreadPool(TASKS);
        try {
            var accountManager = new AccountManagerSincronizado();
            for(int i = 0; i < TASKS; i++)
                service.submit(() -> accountManager.creditar(1d));
        } finally {
            service.shutdown();
        }
    }
}
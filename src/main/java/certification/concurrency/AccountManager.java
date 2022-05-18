package certification.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Account {
    public double balance = 0;
}

public class AccountManager {

    private Account account = new Account();

    private void creditar(double valor) {
        account.balance += valor;
        System.out.print((account.balance)+" ");
    }

    public static void main(String[] args) {
        final int TASKS = 5;
        ExecutorService service = Executors.newFixedThreadPool(TASKS);
        try {
            AccountManager accountManager = new AccountManager();
            for(int i = 0; i < TASKS; i++)
                service.submit(() -> accountManager.creditar(1d));
        } finally {
            service.shutdown();
        }
    }
}
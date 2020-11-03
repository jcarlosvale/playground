package tests.trivago;

//
// Please have a look at the following code.
//
// What does the code do?
// What is problematic with this implementation?
// How could the problems be solved?
//
public class Account {

    // This number must be unique because it
    //  identifies this account.
    private final int accountNumber;
    private double money = 0;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void transfer(Account transferTo, double amount) {

        synchronized (transferTo) {

            synchronized (this) {
                transferTo.money += amount;
                this.money -= amount;
            }
        }
    }

    public double getCurrentAmount() {
        return money;
    }
}

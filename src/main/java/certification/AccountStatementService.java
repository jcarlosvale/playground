package certification;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AccountStatementService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;

    public AccountStatementService(UserRepository userRepository, AddressRepository addressRepository,
                                   BalanceRepository balanceRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
    }

    // this method must take 30 seconds max
    AccountStatement getAccountStatement(long userId) {

        User user = userRepository.getUser(userId);                                  // 20 seconds blocking operation
        Address address = addressRepository.getUserAddress(userId);                  // 20 seconds blocking operation
        AccountBalance accountBalance = balanceRepository.getAccountBalance(userId); // 20 seconds blocking operation

        return AccountStatementBuilder.create(user)
                .withAddress(address)
                .withAccountBalance(accountBalance)
                .build();
    }

    public static void main(String[] args) {
        final var accountStatementService = new AccountStatementService(new UserRepository(), new AddressRepository(),
                new BalanceRepository());

        accountStatementService.getAccountStatement(25);
    }
}

class AccountStatement {

    private final User user;
    private final Address address;
    private final AccountBalance balance;

    AccountStatement(User user, Address address, AccountBalance balance) {
        this.user = user;
        this.address = address;
        this.balance = balance;
    }
}

class AccountStatementBuilder {

    private final User user;
    private Address address;
    private AccountBalance accountBalance;

    private AccountStatementBuilder(User user) {
        this.user = user;
    }

    static AccountStatementBuilder create(User user) {
        return new AccountStatementBuilder(user);
    }

    AccountStatementBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    AccountStatementBuilder withAccountBalance(AccountBalance accountBalance) {
        this.accountBalance = accountBalance;
        return this;
    }

    AccountStatement build() {
        return new AccountStatement(user, address, accountBalance);
    }
}

class User {}

class UserRepository {

    User getUser(long userId) {
        ExpensiveComputation.compute("Retrieving user " + userId);

        return new User();
    }
}

class Address {}

class AddressRepository {

    Address getUserAddress(long userId) {
        ExpensiveComputation.compute("Retrieving the address of user " + userId);
        return new Address();
    }
}

class AccountBalance {}

class BalanceRepository {

    AccountBalance getAccountBalance(long userId) {
        ExpensiveComputation.compute("Retrieving the balance of user " + userId);
        return new AccountBalance();
    }
}

class ExpensiveComputation {

    static void compute(String computationName) {
        // do not edit this
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2A, 18);
        final long start = System.nanoTime();
        passwordEncoder.encode("text");
        final long end = System.nanoTime();
        System.out.printf("%s took %d ms%n", computationName, (end - start) / 1000000);
    }
}

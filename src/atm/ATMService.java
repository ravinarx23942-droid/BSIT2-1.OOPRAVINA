package atm;

public class ATMService {
    // ---------- OVERLOADING: same name, different parameter lists ----------
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
    }
    public void deposit(Account account, double amount, String note) {

        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f%n",
                amount
        );

        System.out.println("Note: " + note);
    }

    public double depositAll(Account account, double... amounts) {
        double total = 0;

        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }
        return total;
    }

    public void tryToReplace(Account account) {
        account = new SavingsAccount("XX-000", "Ghost Account", 0, 0);
        System.out.println("Inside the method : " + account);
// TODO 3: in a comment, explain why the account variable in main()
        // Java passes arguments by value. The account reference is copied
        // into this method. Reassigning the local copy does not change the
        // original account variable in main(), so main() still points to
        // the original Account object.
    }
    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);
// TODO 4: in a comment, explain why THIS change IS visible to main(),
        // The reference is passed by value, but both the parameter and the
        // variable in main() refer to the same Account object. Therefore,
        // changing the object's balance is visible in main().

    }
    // ---------- TRANSFER ----------
    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {
// TODO 5: withdraw from 'from', then deposit into 'to'.
        to.deposit(amount);
    }
}

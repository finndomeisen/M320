public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " CHF eingezahlt.");
        } else {
            System.out.println("Ungueltiger Betrag.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Ungueltiger Betrag.");
        } else if (amount > balance) {
            System.out.println("Nicht genug Guthaben.");
        } else {
            balance -= amount;
            System.out.println(amount + " CHF abgehoben.");
        }
    }

    public void transfer(BankAccount target, double amount) {
        if (amount <= 0) {
            System.out.println("Ungueltiger Betrag.");
        } else if (amount > balance) {
            System.out.println("Nicht genug Guthaben zum Ueberweisen.");
        } else {
            balance -= amount;
            target.deposit(amount);
            System.out.println("Es wurden " + amount + " CHF an " + target.getOwner() + " ueberwiesen.");
        }
    }
}

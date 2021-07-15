import java.util.Objects;

public class BankAccount {
    private double balance = 0.0;
    private String accountNumber;
    private double lineOfCredit;
    private AccountState state;
    private AccountState positive = new Positive();
    private AccountState negative = new Negative();
    private AccountState frozen = new Frozen();
    private AccountState closed = new Closed();

    public BankAccount(String accountNumber, double lineOfCredit) {
        if (accountNumber.isEmpty()) throw new IllegalArgumentException();
        this.accountNumber = Objects.requireNonNull(accountNumber);
        this.lineOfCredit = lineOfCredit;
        this.state = positive;
    }

    public String getState() {
        return state.toString();
    }

    public boolean close() {
        if (this.balance == 0.0) {
            this.state = this.closed;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean payIn(double amount) {
        if (amount <= 0.0) throw new IllegalArgumentException();
        return this.state.payIn(amount);
    }
    public boolean payOff(double amount) {
        if (amount <= 0.0) throw new IllegalArgumentException();
        return this.state.payOff(amount);
    }

    public void payInterest() {
        this.state.payInterest();
    }

    public void printBalance() {
        this.state.printBalance();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    abstract class AccountState {
        public boolean payIn(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();
            balance += amount;
            return true;
        }
        public boolean payOff(double amount) {
            if (amount <= 0) throw new IllegalArgumentException();
            var downBorder = lineOfCredit * (-1);
            if (balance - amount < downBorder) return false;
            else balance -= amount;
            return true;
        }
        public abstract void printBalance();
        public void payInterest(){};
    }

    class Positive extends AccountState {
        @Override
        public boolean payIn(double amount) {
            return super.payIn(amount);
        }
        @Override
        public boolean payOff(double amount) {
            boolean doTransaction = super.payOff(amount);
            if (!doTransaction) return false;
            if (balance <= -lineOfCredit) {
                balance = -lineOfCredit;
                state = frozen;
            } else if (balance < 0) state = negative;
            return true;
        }
        @Override
        public void payInterest() {
            balance = balance * 1.01;
        }
        @Override
        public void printBalance() {
            System.out.println("Balance is POSITIVE: +" + balance + ".");
        }

        @Override
        public String toString() {
            return "Positive";
        }

    }
    class Negative extends AccountState {
        @Override
        public boolean payIn(double amount) {
            super.payIn(amount);
            if (balance >= 0) {
                state = positive;
            }
            return true;
        }
        @Override
        public boolean payOff(double amount) {
            boolean doTransaction = super.payOff(amount);
            if (!doTransaction) return false;
            if (balance <= -lineOfCredit) {
                balance = -lineOfCredit;
                state = frozen;
            }
            return true;
        }
        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE: " + balance + ".");
        }
        @Override
        public void payInterest() {
            balance = balance * 1.03;
            if (balance <= -lineOfCredit) {
                balance = -lineOfCredit;
                state = frozen;
            }
        }

        @Override
        public String toString() {
            return "Negative";
        }

    }
    class Frozen extends AccountState {
        @Override
        public boolean payIn(double amount) {
            super.payIn(amount);
            if (balance > -lineOfCredit) state = negative;
            if (balance >= 0) state = positive;
            return true;
        }
        @Override
        public boolean payOff(double amount) {
            throw new IllegalStateException();
        }
        @Override
        public void payInterest() {
            balance = balance * 1.05;
        }
        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE: " + balance + ". You need to pay in money.");
        }
        @Override
        public String toString() {
            return "Frozen";
        }

    }
    class Closed extends AccountState {
        @Override
        public boolean payIn(double amount) {
            throw new IllegalStateException();
        }
        @Override
        public boolean payOff(double amount) {
            throw new IllegalStateException();
        }
        @Override
        public void printBalance() {
            System.out.println("This account is CLOSED. The balance is 0.");
        }
        @Override
        public void payInterest() {
            throw new IllegalStateException();
        }
        @Override
        public String toString() {
            return "Closed";
        }

    }

}
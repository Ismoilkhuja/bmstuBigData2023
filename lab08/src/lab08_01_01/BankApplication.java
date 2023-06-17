package lab08_01_01;
import java.util.Random;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнение: " + amount + " | Текущий баланс: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снятие: " + amount + " | Текущий баланс: " + balance);
        } else {
            System.out.println("Недостаточно денежных средств");
        }
    }
}

class BankThread implements Runnable {
    private BankAccount account;
    private Random random = new Random();

    public BankThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = random.nextInt(100);
            account.deposit(amount);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            amount = random.nextInt(100);
            account.withdraw(amount);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BankApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread thread1 = new Thread(new BankThread(account));
        Thread thread2 = new Thread(new BankThread(account));

        thread1.start();
        thread2.start();
    }
}

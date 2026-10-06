import java.util.Scanner;

interface Payment {
    void pay(double amount);
    double getProcessingFee();
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("%.2f%n", amount);
    }

    public double getProcessingFee() {
        return 0.02;
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("%.2f%n", amount);
    }

    public double getProcessingFee() {
        return 0.01;
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("%.2f%n", amount);
    }

    public double getProcessingFee() {
        return 0.015;
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        double fee = amount * payment.getProcessingFee();
        return amount + fee;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {
            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;

            if (paymentType == 1) {
                payment = new CreditCardPayment();
            } else if (paymentType == 2) {
                payment = new UPIPayment();
            } else {
                payment = new NetBankingPayment();
            }

            double finalAmount = processor.processPayment(payment, amount);

            payment.pay(finalAmount);
        }

        sc.close();
    }
}

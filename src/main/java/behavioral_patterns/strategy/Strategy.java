package behavioral_patterns.strategy;

public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPaymentStrategy("1234-5678-9876-5432", "John Doe"));
        cart.checkout(250);

        cart.setPaymentStrategy(new PayPalPaymentStrategy("john.doe@example.com"));
        cart.checkout(120);
    }
}

// Общий интерфейс для всех стратегий
interface PaymentStrategy {
    void pay(int amount);
}


// Реализация стратегии для оплаты кредитной картой
class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPaymentStrategy(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with Credit Card: " + cardNumber);
    }
}

// Реализация стратегии для оплаты через PayPal
class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal: " + email);
    }
}



class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}


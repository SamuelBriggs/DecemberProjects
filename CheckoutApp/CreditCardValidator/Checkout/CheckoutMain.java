package ClassProjects.CheckoutApp.CreditCardValidator.Checkout;

public class CheckoutMain {
    public static void main(String[] args) {
        CheckoutServerClass checkout = new CheckoutServerClass();
        checkout.printReceipt();
        checkout.displayBills();
        checkout.displayPayment();
    }
}

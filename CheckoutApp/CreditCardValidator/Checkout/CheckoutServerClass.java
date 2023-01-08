package ClassProjects.CheckoutApp.CreditCardValidator.Checkout;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CheckoutServerClass {

    Date date = new Date();
    private final double VAT = 17.5;
    Scanner scanner = new Scanner(System.in);
    private String customerName;
    private double discount;
    private String cashierName;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Double> priceOfItems = new ArrayList<>();
    private ArrayList<Integer> quantityOfItems = new ArrayList<>();

    private ArrayList<Double> totalOfItems = new ArrayList<>();
    public void setCustomerName() {
        System.out.println("What is the Customer's Name");
        String name = scanner.nextLine();
        this.customerName = name;
    }
    public void setCashierName() {
        System.out.println("What is your Name?");
        String name = scanner.nextLine();
        this.cashierName = name;
    }

    public void setDiscount() {
        System.out.println("How much discount will he get? ");
        Double discount= Double.parseDouble(scanner.nextLine());
        this.discount = discount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addProductsToCart() {
        System.out.println("What did the user buy");
        String itemBought = scanner.nextLine();
        items.add(itemBought);
    }

    public void addPriceOfProducts() {
        System.out.println("How much per unit? :");
        Double price = Double.parseDouble(scanner.nextLine());
        priceOfItems.add(price);
    }

    public void addQuantityOfProducts() {
        System.out.println("How many pieces? :");
        Integer quantity = Integer.parseInt(scanner.nextLine());
        quantityOfItems.add(quantity);
    }

    public void addItemsToCart() {
        setCustomerName();
        String sentinel;
        do {
            addProductsToCart();
            addQuantityOfProducts();
            addPriceOfProducts();
            System.out.println("Add more Items?");
            sentinel = scanner.nextLine();
        }
        while (sentinel.equals("yes"));
        setCashierName();
        setDiscount();
    }

    public void printDashedLines(){
        String dash = "======================================================================";
        System.out.println(dash);
    }

    public void storeInfoHeader(){
        String address =  """
                SEMICOLON STORES 
                MAIN BRANCH 
                LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS. 
                TEL: 03293848493
                """;
        System.out.print(address);
        System.out.println("Date: " + date);
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
    }

    public void printReceipt(){
        addItemsToCart();
        storeInfoHeader();
        printDashedLines();
        printItemsHeaders();
        displayItems();
    }

    public void printItemsHeaders(){
        System.out.printf("%30s%10s%10s%15S", "ITEM", "QTY", "PRICE", "TOTAL(NGN)" );
        System.out.println();
    }

    public void displayItems(){
        for (int i = 0; i < items.size() ; i++) {
            System.out.printf("%30s", items.get(i));
            System.out.printf("%10s", quantityOfItems.get(i));
            System.out.printf("%10s", priceOfItems.get(i));
            totalCalc(i);
            System.out.printf("%14s", totalOfItems.get(i));
            System.out.println();

        }
        System.out.println("---------------------------------------------------------------------");;
    }

    public void totalCalc(int index){
        int qty = quantityOfItems.get(index);
        double price = priceOfItems.get(index);
        double total = (double) qty * price;
        total = (total * 100.0) / 100.0;
        totalOfItems.add(total);
    }

    public Double returnSubTotal(ArrayList<Double> arr){
        double subTotal = 0;
        for (double total: arr){
            subTotal = subTotal + total;
        }
        return subTotal;
    }

    public double returnDiscount(){
        double discount = (this.discount/100.0) * returnSubTotal(totalOfItems);
                discount = Math.round  (discount * 100.0) / 100.0;
        return discount;
    }public double returnVatRate(){
        double vatRate = (this.VAT/100) * returnSubTotal(totalOfItems);
        vatRate = Math.round (vatRate * 100.0) / 100;
        return vatRate;
    }
    public double returnBillTotalCalc(){
        double billTotal = returnSubTotal(totalOfItems) + returnVatRate() - returnDiscount();

        return billTotal;
    }

    public void displayBills(){
        System.out.printf("%37s%12s%n", "Sub Total: ", returnSubTotal(totalOfItems) );
        System.out.printf("%37s%12s%n", "Discount: ", returnDiscount() );
        System.out.printf("%37s%12s%n", "VAT @ 17.5: ", returnVatRate() );
        printDashedLines();
        System.out.printf("%37s%12s%n", "Bill Total: ", returnBillTotalCalc() );
        printDashedLines();
        System.out.println();
        System.out.println("THIS IS NOT A RECEIPT KINDLY PAY " + returnBillTotalCalc());
        printDashedLines();
        System.out.println();
    }

    public void displayPayment(){
        System.out.println("How Much did the customer give to you? ");
        double amountPaid = scanner.nextInt();

        while (amountPaid < returnBillTotalCalc())
        {
            System.out.println("Enter a valid amount");
            amountPaid = scanner.nextInt();
        }
        double balance = amountPaid - returnBillTotalCalc();
            balance = Math.round(balance * 100.0) / 100.0;
        if (amountPaid > returnBillTotalCalc()){
            storeInfoHeader();
            printDashedLines();
            printItemsHeaders();
            System.out.printf("%37s%12s%n", "Sub Total: ", returnSubTotal(totalOfItems) );
            System.out.printf("%37s%12s%n", "Discount: ", returnDiscount() );
            System.out.printf("%37s%12s%n", "VAT @ 17.5: ", returnVatRate() );
            printDashedLines();
            System.out.printf("%37s%12s%n", "Bill Total: ", returnBillTotalCalc());
            System.out.printf("%37s%12s%n", "Amount Paid: ", amountPaid);
            System.out.printf("%37s%12s%n", "Balance: ", balance);
            printDashedLines();
            System.out.printf("%40s%n", "THANKS FOR YOUR PATRONAGE");
            printDashedLines();
        }




    }













}



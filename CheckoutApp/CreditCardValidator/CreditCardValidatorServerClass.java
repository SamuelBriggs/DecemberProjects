package ClassProjects.CheckoutApp.CreditCardValidator;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Scanner;

public class CreditCardValidatorServerClass {
    Scanner scanner = new Scanner(System.in);
    String creditCard;
    ArrayList<Integer> creditCardNums = new ArrayList<>();


    public void display(){
        setCreditCardNums();
        printCardStatus();
        System.out.println("Credit Card Number: " + creditCard);
        System.out.println("Credit Card Length: " + creditCard.length());
        checkIfCardIsValid();

    }
    public void setCreditCard() {
        System.out.println("Enter Card Number Between 13 and 16 Digits: ");
        String input = scanner.next();
        while (input.length() < 13 || input.length() > 16) {
            System.out.println("Enter a Valid Number between 13 and 16 digits");
            input = scanner.next();
        }
        if(input.length() > 13 & input.length() <= 16) creditCard = input;
    }
    public String returnCard() {
        return creditCard;}
    public void setCreditCardNums() {
        for (int i = 0; i < creditCard.length(); i++) {
            creditCardNums.add(Integer.parseInt(creditCard.substring(i, i + 1)));
        }}
        public ArrayList<Integer> returnEveryDoubleDigitFromRtoL(){
            ArrayList<Integer> doubleDigitsFromRtoL = new ArrayList<>();
            for (int i =creditCard.length()-2; 0<=i; i-=2){
                int number = creditCardNums.get(i);
                if ((number*2) > 9){
                    doubleDigitsFromRtoL.add(returnAdditionOfDoublingNumbers(number*2));
                }
                else{
                doubleDigitsFromRtoL.add(number*2);}
            }
            return doubleDigitsFromRtoL;
        }

        public int returnAdditionOfDoublingNumbers(Integer doubleNum){
            int firstNum = doubleNum / 10;
            int secondNum = doubleNum % 10;
            return firstNum + secondNum;
        }

        public ArrayList<Integer> returnDigitsFromOddPlaces(){
        ArrayList<Integer> digitsFromOddPlaces = new ArrayList<>();
            for (int i = creditCard.length()-1; i>=0 ; i-=2) {
                digitsFromOddPlaces.add(creditCardNums.get(i));
            }
        return digitsFromOddPlaces;
        }

        public int addItemsInArr(ArrayList<Integer> arr){
            int total = 0;
                for (int element:arr) {
                    total = total+element;
                }
            return total;
        }

        public void checkIfCardIsValid(){
        boolean check = false;
        if ((addItemsInArr(returnDigitsFromOddPlaces()) + addItemsInArr(returnEveryDoubleDigitFromRtoL()))  % 2 == 0) {check = true;

        if(check) System.out.println("Credit Card Validity Status: Valid");
        }
        else System.out.println("Credit Card Validity Status: Invalid");
    }

        public void printCardStatus(){
        if (creditCardNums.get(0) == 4) System.out.println("Credit Card Type: VisaCard");
        else if (creditCardNums.get(0)==5) {
            System.out.println("Credit Card Type: MasterCard");
        } else if (creditCardNums.get(0)==3 & creditCardNums.get(1)==7){
            System.out.println("Credit Card Type: American Express Card");
        } else if (creditCardNums.get(0) == 6) {
            System.out.println("Credit Card Type: Discover Card");
        }
        else System.out.println("Credit Card Type: Invalid Card");
        }

    }







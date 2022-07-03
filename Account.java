import java.util.Scanner;

public class Account {
    int balance; 
    int prevTransactions;
    String customerName;
    String customerID;

    //constructor for initializing the account name and number
    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }

    // function for depositing the amount
    void depositMoney(int amount){
        if(amount != 0){
            balance = balance + amount;
            prevTransactions = amount;
        }
    }

    //function for withdrawMoney
    void withdrawMoney(int amount){
        if(amount > balance){
            System.out.println("Balance not enough to withdraw");
        }
        else{
            balance = balance - amount;
            prevTransactions = -amount;
        }
    }

    //function for prevTransactions
    void getPrevTransactions(){
        if (prevTransactions > 0){
            System.out.println("Deposited: " + prevTransactions);
        }
        else if(prevTransactions < 0){
            System.out.println("WithDrawn: "+ Math.abs(prevTransactions));
        }
        else{
            System.out.println("No transactions occured");
        }
    }

    //function for calculating interest 
    void calculateInterest(int years){
        double interestRate = 0.0185;
        double newBalance = (balance + balance*interestRate*years);
        System.out.println("The current interest rate is " + (100*interestRate));
        System.out.println("After " + years + "years, your Balance will be: " + newBalance);
    }

    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome," + customerName+ "!");
        System.out.println("Account number: " + customerID);
        System.out.println();
        System.out.println("Enter what you would like to do: ");
        System.out.println();
        System.out.println("A: Check your account balance");
        System.out.println("B: Make a deposit");
        System.out.println("C: Make a withdrawl");
        System.out.println("D: View Previous Transactions");
        System.out.println("E: Calculate Interest");
        System.out.println("F: Exit the application");

        do{
            System.out.println();
            System.out.println("Enter an option(A,B,C,D,E,F): ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A': 
                    System.out.println("====================================");
                    System.out.println("Balance: " + balance);
                    System.out.println("====================================");
                    break;

                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int amount = sc.nextInt();
                    depositMoney(amount);
                    System.out.println();
                    break;
                
                case 'C':
                    System.out.println("Enter amount to withdraw: ");
                    int amount2 = sc.nextInt();
                    withdrawMoney(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("====================================");
                    getPrevTransactions();
                    System.out.println("====================================");
                    break;

                case 'E':
                    System.out.println("Enter the number of years:");
                    int time = sc.nextInt();
                    calculateInterest(time);
                    break;

                case 'F':
                    System.out.println("===============================");
                    break;
                    
                default: 
                    System.out.println("Error : Invalid option. Please enter A, B, C, D, E OR F only");    
            }
        }while(option != 'F');
    System.out.println("Thanks for using our application");
    }
}

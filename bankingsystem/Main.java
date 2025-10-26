package bankingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();

        // create acc's with accountNumber and balance
        savingsAccounts.add(new SavingsAccount(101, 500.0));
        savingsAccounts.add(new SavingsAccount(102, 1000.0));

        checkingAccounts.add(new CheckingAccount(201, 1500.0));
        checkingAccounts.add(new CheckingAccount(202, 2000.0));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
        	System.out.println("1. Deposit\n2. Withdraw\n3. Show account info\n4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1: // Deposit
                    System.out.println("Which account type?");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Checking Account");
                    int depositType = sc.nextInt();

                    System.out.print("Enter account number: ");
                    int depositAccNum = sc.nextInt();

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();

                    boolean foundDeposit = false;

                    if(depositType == 1) {
                        for(SavingsAccount sa : savingsAccounts) {
                            if(sa.accountNumber == depositAccNum) {
                                sa.deposit(depositAmount);
                                foundDeposit = true;
                                break;
                            }
                        }
                    } else if(depositType == 2) {
                        for(CheckingAccount ca : checkingAccounts) {
                            if(ca.accountNumber == depositAccNum) {
                                ca.deposit(depositAmount);
                                foundDeposit = true;
                                break;
                            }
                        }
                    }

                    if(!foundDeposit) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 2: // Withdraw
                    System.out.println("Which account type?");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Checking Account");
                    int withdrawType = sc.nextInt();

                    System.out.print("Enter account number: ");
                    int withdrawAccNum = sc.nextInt();

                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();

                    boolean foundWithdraw = false;

                    if(withdrawType == 1) {
                        for(SavingsAccount sa : savingsAccounts) {
                            if(sa.accountNumber == withdrawAccNum) {
                                sa.withdraw(withdrawAmount);
                                foundWithdraw = true;
                                break;
                            }
                        }
                    } else if(withdrawType == 2) {
                        for(CheckingAccount ca : checkingAccounts) {
                            if(ca.accountNumber == withdrawAccNum) {
                                ca.withdraw(withdrawAmount);
                                foundWithdraw = true;
                                break;
                            }
                        }
                    }

                    if(!foundWithdraw) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3: // Show all balances
                    System.out.println("\n--Savings Accounts--");
                    for(SavingsAccount sa : savingsAccounts) {
                        System.out.println("Account " + sa.accountNumber + ": " + sa.balance);
                    }
                    System.out.println("\n--Checking Accounts--");
                    for(CheckingAccount ca : checkingAccounts) {
                        System.out.println("Account " + ca.accountNumber + ": " + ca.balance);
                    }
                    System.out.println(" ");
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}
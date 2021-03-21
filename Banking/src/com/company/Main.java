package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Customer customer = new Customer("Vlad");
    private static Branch branches = new Branch("Assurance");
    private static Bank bank = new Bank("BRD");

    public static void main(String[] args) {
       /* customer.AddTransactions(200.00);
        customer.AddTransactions(400.00);
        customer.ShowTransactions();        // Test Customer Class
        branches.AddNewCustomer(customer);
        branches.ShowCustomerData();
        branches.QueryCustomer("Vlad",200.00);*/
        boolean quit = false;
        int choice = 0;
        PrintInstructions();
        while (!quit) {
            System.out.println("Type your choice: ");
            boolean checker = scanner.hasNextInt();

            if (checker) {
                choice = scanner.nextInt();
                scanner.nextLine(); // daca nu as goli subbeferul ar  ramane enter in subbuffer
                switch (choice) {
                    case 0:
                        PrintInstructions();
                        break;
                    case 1:
                        ShowBankData();
                        break;
                    case 2:
                        AddBranch();
                        break;
                    case 3:
                        AddCustomer();
                        break;
                    case 4:
                        AddTransaction();
                        break;

                    case 5:
                        DeleteTransaction();
                        break;
                    case 6:
                        System.out.println("Thank you for using my app.");
                        quit = true;
                        break;


                }
            } else {
                System.out.println("Type again correctly,please.");
                scanner.nextLine(); // ! CLEAR BUFFER CLEAR BUFFER
            }
        }

    }


    public static void PrintInstructions() {
        System.out.println("\nPress:");
        System.out.println("\t 0 - To show instructions.");
        System.out.println("\t 1 - To show the bank data.");
        System.out.println("\t 2 - To add a branch.");
        System.out.println("\t 3 - To add a customer.");
        System.out.println("\t 4 - To add a transaction.");
        System.out.println("\t 5 - To delete a transaction.");
        System.out.println("\t 6 - To quit application.");
        //System.out.println("\t 2 - To show ");
    }

    public static void ShowBankData() {
        bank.ShowBankData();
    }

    public static void AddBranch() {
        System.out.println("Enter the name of the branch,please.");
        String BranchName = scanner.nextLine();
        bank.addBranch(new Branch(BranchName));

    }

    public static void AddCustomer() {
        System.out.println("Enter the name of the branch you want to add the customer to.");
        String BranchName = scanner.nextLine();
        if (bank.BranchNameCheck(BranchName) == false) {
            System.out.println("The bank has no such branch, please try again.");
        } else {
            System.out.println("Enter the name of the customer you want to add: ");
            String CustomerName = scanner.nextLine();
            bank.AddCustomer(CustomerName, BranchName);
        }
    }

    public static void AddTransaction() {
        System.out.println("Enter the name of the branch, please.");
        String BranchName = scanner.nextLine();
        System.out.println("Enter the name of the customer, please.");
        String CustomerName = scanner.nextLine();
        System.out.println("Enter the sum of transaction, please.");
        double transaction = scanner.nextDouble();
        bank.AddCustomerTransaction(BranchName, CustomerName, transaction);

    }

    public static void DeleteTransaction() {
        System.out.println("Enter the name of the branch, please.");
        String BranchName = scanner.nextLine();
        System.out.println("Enter the name of the customer, please.");
        String CustomerName = scanner.nextLine();
        System.out.println("Enter the sum of transaction, please.");
        double transaction = scanner.nextDouble();
        bank.DeleteTransaction(BranchName, CustomerName, transaction);
    }


}

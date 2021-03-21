package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }


    public void AddTransactions(double transaction)
    {
        this.transactions.add(transaction);
        System.out.println("The transaction has been made successfully.");
    }

    public void DeleteTransactions(double TransactionIndex)
    {
        this.transactions.remove(TransactionIndex);
        System.out.println("The transaction has been deleted successfully.");
    }

    public void ShowTransactions()
    {   if(transactions.size() != 0) {
        System.out.println("The client " + this.getName() + " has the following transactions: ");
        for (int i = 0; i < transactions.size(); i++)
            System.out.println("Transaction #" + (i + 1) + " ---> " + this.getTransactions().get(i));
    }
    else System.out.println("The client " + this.name + " has no transactions.");
    }

    public void ClearTransactions()
    {
        this.transactions.clear();
    }


}

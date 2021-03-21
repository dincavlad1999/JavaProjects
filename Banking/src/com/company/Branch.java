package com.company;

import java.util.ArrayList;

public class Branch {
    public String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void AddNewCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void ShowCustomerData() {
        if (customers.size() != 0) {
            System.out.println("The customers data registered to " + this.name + " branch are: ");
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("Customer number " + (i + 1) + " data is: ");
                customers.get(i).ShowTransactions();
            }
        } else System.out.println("The bank branch " + this.name + " has no clients registered.");
    }

    public void ClearClients() {
        this.customers.clear();
    }

    public boolean QueryCustomer(String name, double InitialTransaction) {
        if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getName().equals(name))
                    if (customers.get(i).getTransactions().get(i).equals(InitialTransaction))
                        System.out.println("The customer " + customers.get(i).getName() + " exists in the bank database.");
                return true;
            }
        } else
            System.out.println("The bank branch " + this.name + " has no clients registered.");
        return false;
    }

    public boolean QueryCustomer(String name) {
        if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getName().equals(name))
                        //System.out.println("The customer " + customers.get(i).getName() + " exists in the bank database.");
                return true;
            }
        } else
            System.out.println("The bank branch " + this.name + " has no clients registered.");
        return false;
    }

    public boolean QueryTransaction(double transaction)
    {
        if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getTransactions().get(i) == transaction)
                    //System.out.println("The customer " + customers.get(i).getName() + " exists in the bank database.");
                    return true;
            }
        } else
            System.out.println("The bank branch " + this.name + " has no clients registered.");
        return false;
    }

    }








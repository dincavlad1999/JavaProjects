package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    /******************************************************************************************************************/
    // FUNCTIONEAZA BINE
    public void addBranch(Branch branch) {
        this.branches.add(branch);
        System.out.println("The branch has been added successfully.");
    }

    /******************************************************************************************************************/
    // FUNCTIONEAZA BINE
    public void ShowBankData() {
        System.out.println("The name of the bank is " + this.name);
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++) {
                String name = this.branches.get(i).getName();
                System.out.println(name + " branch related data: ");
                if (this.branches.get(i).getCustomers().size() != 0)
                    this.branches.get(i).ShowCustomerData();
                else System.out.println("The branch has no customers.");
            }
        } else System.out.println("The bank data is empty.");
    }

    /******************************************************************************************************************/
 /*   private int BranchNameIndex(String BranchName) {
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++)
                if (branches.get(i).getName().equals(BranchName))
                    return this.branches.indexOf(branches.get(i));

        } else System.out.println("The bank does not have this branch.");
        return -1;

    }*/

    /******************************************************************************************************************/
    public boolean BranchNameCheck(String BranchName) {
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++)
                if (branches.get(i).getName().equals(BranchName))
                    return true;

        }
        return false;

    }

    public int BranchNameIndex(String BranchName) {
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++)
                if (branches.get(i).getName().equals(BranchName))
                    return this.branches.indexOf(branches.get(i));

        }
        return -1;


    }

    public boolean CustomerNameCheck(String CustomerName) {
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++)
                if (branches.get(i).QueryCustomer(CustomerName))
                    return true;

        }
        return false;

    }

    public int CustomerNameIndex(String CustomerName) {
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++)
                if (branches.get(i).QueryCustomer(CustomerName))
                    return this.branches.indexOf(branches.get(i));

        }
        return -1;

    }

    public int CustomerTransactionIndex(double transaciton) {
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++)
                if (branches.get(i).QueryTransaction(transaciton))
                    return this.branches.indexOf(branches.get(i));

        }
        return -1;

    }

    /******************************************************************************************************************/

    public void AddCustomer(String CustomerName, String BranchName) {

        this.branches.get(this.BranchNameIndex(BranchName)).AddNewCustomer(new Customer(CustomerName));
        System.out.println("Customer has been added.");

    }

    /******************************************************************************************************************/
    // WORK FINE
    public void AddCustomerTransaction(String BranchName, String CustomerName, double tranzactie) {
        if(branches.size() != 0) {
            if (this.BranchNameCheck(BranchName) == false) {
                System.out.println("The bank has no such branch, please try again.");
            } else if (this.CustomerNameCheck(CustomerName) == false) {
                System.out.println("The branch does not have this customer.");
            } else {
                //for (int i = 0; i < this.branches.size(); i++)
                    this.branches.get(this.BranchNameIndex(BranchName)).getCustomers().get(this.CustomerNameIndex(CustomerName)).AddTransactions(tranzactie);

            }
        }
        else System.out.println("The bank data is empty.");
    }

    /******************************************************************************************************************/
       public void DeleteTransaction(String BranchName, String CustomerName, double transaction)
        {
            if(branches.size() != 0) {
                if (this.BranchNameCheck(BranchName) == false) {
                    System.out.println("The bank has no such branch, please try again.");
                } else if (this.CustomerNameCheck(CustomerName) == false) {
                    System.out.println("The branch does not have this customer.");
                } else {
                     this.branches.get(this.BranchNameIndex(BranchName)).getCustomers().get(this.CustomerNameIndex(CustomerName)).DeleteTransactions(transaction);

                }
            }
            else System.out.println("The bank data is empty.");


        }

}
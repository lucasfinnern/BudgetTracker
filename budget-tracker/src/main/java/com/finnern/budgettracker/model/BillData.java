package com.finnern.budgettracker.model;

import java.util.ArrayList;

public class BillData {

    private static ArrayList<PaymentCost> billList = new ArrayList<PaymentCost>();

    //adds a payment to the billList
    public static void addPayment(PaymentCost aPayment) {
        billList.add(aPayment);
    }

    //returns the list of payments (billList)
    public static ArrayList<PaymentCost> returnPayments() {
        return billList;
    }

    //removes a bill at a specific index
    public static void remove(int theIndex) {
        billList.remove(theIndex);
    }

    //searches and sums the bills for a given month
    //search terms must be: jan, feb, mar, apr, may, jun, jul, aug, sept, oct, nov, dec
    public static Integer sumPayments(String monthSearched) {
        Integer sum = 0;
        for (int i = 0; i < billList.size(); i++) {
            if(billList.get(i).getMonths().contains(monthSearched)) {
                sum += billList.get(i).getCost();
            }
        }

        return sum;
    }

    //return the payments for a given month
    //search terms must be: jan, feb, mar, apr, may, jun, jul, aug, sept, oct, nov, dec
    public static ArrayList<PaymentCost> returnMonthlyPayments(ArrayList<PaymentCost> theWholeListOfPayments, String monthSearched) {
        ArrayList<PaymentCost> paymentsForAMonth = new ArrayList<PaymentCost>();
        for (int i = 0; i < theWholeListOfPayments.size(); i++) {
            if(theWholeListOfPayments.get(i).getMonths().contains(monthSearched)) {
                paymentsForAMonth.add(theWholeListOfPayments.get(i));
            }
        }
        return paymentsForAMonth;
    }

    //returns the difference between two Integer objects
    public static Integer subPaymentsFromBudgets(Integer aBudget, Integer aPayment) {
        Integer result;
        result = aBudget - aPayment;

        return result;
    }
}

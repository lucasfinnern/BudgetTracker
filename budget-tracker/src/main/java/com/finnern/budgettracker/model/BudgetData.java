package com.finnern.budgettracker.model;

import java.util.LinkedHashMap;

public class BudgetData {

    //hashmap with <month,amount of budget allowed>
    public static LinkedHashMap<String, Integer> budgetPlanner = new LinkedHashMap<String, Integer>();



    //creates LinkedHashMap with zero budgets across the board
    public static void createBudgets() {
        //strings for all the months and Integer of 0
        String jan = "jan";
        String feb = "feb";
        String mar = "mar";
        String apr = "apr";
        String may = "may";
        String jun = "jun";
        String jul = "jul";
        String aug = "aug";
        String sept = "sept";
        String oct = "oct";
        String nov = "nov";
        String dec = "dec";
        Integer startBud = 0;
        budgetPlanner.put(jan, startBud);
        budgetPlanner.put(feb, startBud);
        budgetPlanner.put(mar, startBud);
        budgetPlanner.put(apr, startBud);
        budgetPlanner.put(may, startBud);
        budgetPlanner.put(jun, startBud);
        budgetPlanner.put(jul, startBud);
        budgetPlanner.put(aug, startBud);
        budgetPlanner.put(sept, startBud);
        budgetPlanner.put(oct, startBud);
        budgetPlanner.put(nov, startBud);
        budgetPlanner.put(dec, startBud);
    }

    public static void putToBudget(String month, Integer budget){
        budgetPlanner.put(month, budget);
    }

    public static LinkedHashMap<String, Integer> returnBudgets() {
        return budgetPlanner;
    }

}

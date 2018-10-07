package com.finnern.budgettracker.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentCost {

    //fields
    private String name;

    private Integer cost;

    private ArrayList<String> months = new ArrayList<>();

    private static int nextIdKey = 0;

    private final int idKey;

    //constructors, getters, setters
    public PaymentCost(String name, Integer cost, ArrayList<String> months) {
        this.name = name;
        this.cost = cost;
        this.months = months;
        this.idKey = nextIdKey;
        nextIdKey++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public ArrayList<String> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<String> months) {
        this.months = months;
    }

    public static int getNextIdKey() {
        return nextIdKey;
    }

    public static void setNextIdKey(int nextIdKey) {
        PaymentCost.nextIdKey = nextIdKey;
    }

    public int getIdKey() {
        return idKey;
    }

    //methods
    public static Integer convert(String aString) {
        Integer aCost = Integer.valueOf(aString);

        return aCost;
    }
}

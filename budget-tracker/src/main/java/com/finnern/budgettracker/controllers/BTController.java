package com.finnern.budgettracker.controllers;

import com.finnern.budgettracker.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedHashMap;


@Controller
@RequestMapping(value = "")
public class BTController {

    //controls path to home
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String displayOverview(Model model) {
        //variable to hold the all the monthly budgets
        LinkedHashMap<String, Integer> theMonthlyBudgets = BudgetData.returnBudgets();

        if(theMonthlyBudgets.isEmpty()) {
            BudgetData.createBudgets();
        }

        //passes a LinkedHashMap of the monthly budgets
        model.addAttribute("theActualBudget", theMonthlyBudgets);

        //passes all the payments for each individual month
        model.addAttribute("janBills", BillData.sumPayments("jan"));
        model.addAttribute("febBills", BillData.sumPayments("feb"));
        model.addAttribute("marBills", BillData.sumPayments("mar"));
        model.addAttribute("aprBills", BillData.sumPayments("apr"));
        model.addAttribute("mayBills", BillData.sumPayments("may"));
        model.addAttribute("junBills", BillData.sumPayments("jun"));
        model.addAttribute("julBills", BillData.sumPayments("jul"));
        model.addAttribute("augBills", BillData.sumPayments("aug"));
        model.addAttribute("septBills", BillData.sumPayments("sept"));
        model.addAttribute("octBills", BillData.sumPayments("oct"));
        model.addAttribute("novBills", BillData.sumPayments("nov"));
        model.addAttribute("decBills", BillData.sumPayments("dec"));

        //calculates and passes the savings for every month
        model.addAttribute("janFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("jan")
                , BillData.sumPayments("jan")));
        model.addAttribute("febFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("feb")
                , BillData.sumPayments("feb")));
        model.addAttribute("marFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("mar")
                , BillData.sumPayments("mar")));
        model.addAttribute("aprFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("apr")
                , BillData.sumPayments("apr")));
        model.addAttribute("mayFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("may")
                , BillData.sumPayments("may")));
        model.addAttribute("junFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("jun")
                , BillData.sumPayments("jun")));
        model.addAttribute("julFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("jul")
                , BillData.sumPayments("jul")));
        model.addAttribute("augFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("aug")
                , BillData.sumPayments("aug")));
        model.addAttribute("septFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("sept")
                , BillData.sumPayments("sept")));
        model.addAttribute("octFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("oct")
                , BillData.sumPayments("oct")));
        model.addAttribute("novFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("nov")
                , BillData.sumPayments("nov")));
        model.addAttribute("decFun", BillData.subPaymentsFromBudgets(theMonthlyBudgets.get("dec")
                , BillData.sumPayments("dec")));
        return "home";
    }

    //controls path budget
    @RequestMapping(value = "budget", method=RequestMethod.GET)
    public String addBudget(Model model
    ) {
        model.addAttribute("budgetVal", BudgetData.returnBudgets());
        return "budget";
    }

    @RequestMapping(value = "budget", method=RequestMethod.POST)
    public String getBudget(@RequestParam String janBudget, String febBudget, String marBudget
            , String aprBudget, String mayBudget, String junBudget, String julBudget, String augBudget
            , String septBudget, String octBudget, String novBudget, String decBudget, Model model) {

        BudgetData.putToBudget("jan", PaymentCost.convert(janBudget));
        BudgetData.putToBudget("feb", PaymentCost.convert(febBudget));
        BudgetData.putToBudget("mar", PaymentCost.convert(marBudget));
        BudgetData.putToBudget("apr", PaymentCost.convert(aprBudget));
        BudgetData.putToBudget("may", PaymentCost.convert(mayBudget));
        BudgetData.putToBudget("jun", PaymentCost.convert(junBudget));
        BudgetData.putToBudget("jul", PaymentCost.convert(julBudget));
        BudgetData.putToBudget("aug", PaymentCost.convert(augBudget));
        BudgetData.putToBudget("sept", PaymentCost.convert(septBudget));
        BudgetData.putToBudget("oct", PaymentCost.convert(octBudget));
        BudgetData.putToBudget("nov", PaymentCost.convert(novBudget));
        BudgetData.putToBudget("dec", PaymentCost.convert(decBudget));
//        Integer newFebBudget = PaymentCost.convert(febBudget);
//        Integer newMarBudget = PaymentCost.convert(marBudget);
//        Integer newAprBudget = PaymentCost.convert(aprBudget);
//        Integer newMayBudget = PaymentCost.convert(mayBudget);
//        Integer newJunBudget = PaymentCost.convert(junBudget);
//        Integer newJulBudget = PaymentCost.convert(julBudget);
//        Integer newAugBudget = PaymentCost.convert(augBudget);
//        Integer newSeptBudget = PaymentCost.convert(septBudget);
//        Integer newOctBudget = PaymentCost.convert(octBudget);
//        Integer newNovBudget = PaymentCost.convert(novBudget);
//        Integer newDecBudget = PaymentCost.convert(decBudget);
//        BudgetData.addAllBudgets("jan", newJanBudget, "feb", newFebBudget, "mar", newMarBudget
//        , "apr", newAprBudget, "may", newMayBudget, "jun", newJunBudget, "jul", newJulBudget
//        , "aug", newAugBudget, "sept", newSeptBudget, "oct", newOctBudget, "nov", newNovBudget
//        , "dec", newDecBudget);
        model.addAttribute("budgetVal", BudgetData.returnBudgets());
        return "budget";
    }

    //controls path to add payments
    @RequestMapping(value = "payments", method = RequestMethod.GET)
    public String makePayment(Model model) {
        return "payments";
    }

    @RequestMapping(value = "payments", method = RequestMethod.POST)
    public String addPayment(@RequestParam String payCost,
                             @RequestParam String payName,
                             @RequestParam ArrayList<String> payOccurrence) {
        Integer intCost = PaymentCost.convert(payCost);
        PaymentCost newPaymentCost = new PaymentCost(payName,intCost, payOccurrence);
        BillData.addPayment(newPaymentCost);
        return "payments";
    }

    //controls path to remove payments
    @RequestMapping(value = "bills", method = RequestMethod.GET)
    public String listPayments(Model model) {
        ArrayList<PaymentCost> paymentList = BillData.returnPayments();
        model.addAttribute("janBills", BillData.returnMonthlyPayments(paymentList, "jan"));
        model.addAttribute("febBills", BillData.returnMonthlyPayments(paymentList, "feb"));
        model.addAttribute("marBills", BillData.returnMonthlyPayments(paymentList, "mar"));
        model.addAttribute("aprBills", BillData.returnMonthlyPayments(paymentList, "apr"));
        model.addAttribute("mayBills", BillData.returnMonthlyPayments(paymentList, "may"));
        model.addAttribute("junBills", BillData.returnMonthlyPayments(paymentList, "jun"));
        model.addAttribute("julBills", BillData.returnMonthlyPayments(paymentList, "jul"));
        model.addAttribute("augBills", BillData.returnMonthlyPayments(paymentList, "aug"));
        model.addAttribute("septBills", BillData.returnMonthlyPayments(paymentList, "sept"));
        model.addAttribute("octBills", BillData.returnMonthlyPayments(paymentList, "oct"));
        model.addAttribute("novBills", BillData.returnMonthlyPayments(paymentList, "nov"));
        model.addAttribute("decBills", BillData.returnMonthlyPayments(paymentList, "dec"));
        /*            model.addAttribute("theList", BillData.returnPayments());*/
        return "bills";
    }

    @RequestMapping(value = "bills", method = RequestMethod.POST)
    public String removePayment(@RequestParam int aBill, Model model) {
        BillData.remove(aBill);
        model.addAttribute("theList", BillData.returnPayments());
        return "bills";
    }
}

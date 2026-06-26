package com.naveen.expensetracker.controller;

import com.naveen.expensetracker.entity.Expense;
import com.naveen.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Welcome to Expense Tracker API!";
    }



    @PostMapping("/expense")
    public Expense saveExpense(@RequestBody Expense expense){

        return expenseService.saveExpense(expense);
    }
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

}

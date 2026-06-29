package com.naveen.expensetracker.controller;

import com.naveen.expensetracker.entity.Expense;
import com.naveen.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable  Long id){
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpense(@RequestBody Expense expense, @PathVariable Long id){
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
        return "Expense deleted successfully.";
    }

}

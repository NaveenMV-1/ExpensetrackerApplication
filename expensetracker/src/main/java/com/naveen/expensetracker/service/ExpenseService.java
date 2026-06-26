package com.naveen.expensetracker.service;

import com.naveen.expensetracker.entity.Expense;
import com.naveen.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense){
        if(expense.getAmount()<=0){
            throw new RuntimeException(
                    "Amount must be greater than 0");
        }
        return expenseRepository.save(expense);
    }

    public Expense getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id);
        if(expense == null){
            throw new RuntimeException("Expense not found");
        }

        return expense;
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();

    }

    public void deleteExpenseById(Long id){
         expenseRepository.deleteById(id);
    }


}
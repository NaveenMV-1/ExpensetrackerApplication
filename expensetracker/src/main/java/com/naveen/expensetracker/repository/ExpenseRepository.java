package com.naveen.expensetracker.repository;


import com.naveen.expensetracker.entity.Expense;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepository {
    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public Expense save(Expense expense) {
        if(expense.getId()==null){
            entityManager.persist(expense);
            return expense;
        }else{
            return entityManager.merge(expense);
        }
    }
    public Expense findById(Long id) {
        return entityManager.find(Expense.class, id);
    }

    public List<Expense> findAll() {
        return entityManager.createQuery("SELECT e from Expense e", Expense.class)
                .getResultList();
    }

    @Transactional
    public void deleteById(Long id) {
        Expense expense = findById(id);
        if (expense != null) {
            entityManager.remove(expense);
        }
    }
}

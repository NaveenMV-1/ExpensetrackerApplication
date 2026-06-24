package com.naveen.expensetracker.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Expense {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private Double amount;
        private String category;

        public Expense() {

        }
        public Expense(Long id, String title, Double amount, String category) {
                this.id = id;
                this.title = title;
                this.amount = amount;
                this.category = category;
        }

        public Long getId() {
                return id;
        }
        public void setId(Long id) {
                this.id = id;
        }

        public String getTitle(){
                return title;
        }
        public void setTitle( String title){
                this.title = title;
        }
        public Double getAmount(){
                return amount;
        }
        public void setAmount(Double amount){
                this.amount = amount;
        }
        public String getCategory(){
                return category;

        }
        public void setCategory(String category){
                this.category = category;
        }

        @Override
        public String toString() {
                return "Expense{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", amount=" + amount +
                        ", category='" + category + '\'' +
                        '}';
        }
}

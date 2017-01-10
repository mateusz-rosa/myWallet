package com.mywallet.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MoneyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long moneyTransactionId;
    private float amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public MoneyTransaction(){
    }

    public MoneyTransaction(float amount, String description){
        this.amount = amount;
        this.description = description;
    }

    public MoneyTransaction(float amount, String description, Category category){
        this.amount = amount;
        this.description = description;
        setCategory(category);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getMoneyTransactionId() {
        return moneyTransactionId;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + moneyTransactionId +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }


}

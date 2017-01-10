package com.mywallet.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mateusz on 2017-01-08.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String nameOfCategory;

    @OneToMany(mappedBy = "category")
    private List<MoneyTransaction> moneyTransactionList;

    public Category() {

    }

    public Category(String nameOfCategory) {
        setNameOfCategory(nameOfCategory);
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public List<MoneyTransaction> getMoneyTransactionList() {
        return moneyTransactionList;
    }

    public void setMoneyTransactionList(List<MoneyTransaction> moneyTransactionList) {
        this.moneyTransactionList = moneyTransactionList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                '}';
    }
}


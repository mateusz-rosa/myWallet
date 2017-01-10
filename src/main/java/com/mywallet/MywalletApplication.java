package com.mywallet;

import com.mywallet.domain.Category;
import com.mywallet.domain.MoneyTransaction;
import com.mywallet.domain.repository.CategoryRepository;
import com.mywallet.domain.repository.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MywalletApplication implements CommandLineRunner {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(MywalletApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        categoryRepository.save(new Category("Pensja"));
        categoryRepository.save(new Category("Rachunki"));
        categoryRepository.save(new Category("Jedzenie"));
        Category cat1 = new Category("Przyjemności");
        categoryRepository.save(cat1);

        moneyTransactionRepository.save(new MoneyTransaction(12,"bo tak",cat1));
        MoneyTransaction mt = new MoneyTransaction(12,"bo tak",cat1);

    }
}

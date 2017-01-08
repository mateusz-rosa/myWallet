package com.mywallet;

import com.mywallet.domain.MoneyTransaction;
import com.mywallet.domain.repository.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MywalletApplication implements CommandLineRunner {

    @Autowired
    private MoneyTransactionRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MywalletApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        for (int i = 0; i < 5; i++) {
            repository.save(new MoneyTransaction((i+1), "default"));
        }
    }
}

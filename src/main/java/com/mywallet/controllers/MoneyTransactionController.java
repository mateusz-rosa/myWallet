package com.mywallet.controllers;

import com.mywallet.domain.MoneyTransaction;
import com.mywallet.domain.repository.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moneyTransactions")
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listMoneyTransactions(Model model) {
        model.addAttribute("moneyTransactions", repository.findAll());
        return "moneyTransactions/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/moneyTransactions");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newMoneyTransaction() {
        return "moneyTransactions/new";
    }       //newProject

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("amount") float amount,
                               @RequestParam("decription") String decription) {
        repository.save(new MoneyTransaction(amount, decription));
        return new ModelAndView("redirect:/moneyTransactions");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("amount") float amount) {
        MoneyTransaction moneyTransaction = repository.findOne(id);
        moneyTransaction.setAmount(amount);
        repository.save(moneyTransaction);
        return new ModelAndView("redirect:/moneyTransactions");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        MoneyTransaction moneyTransaction = repository.findOne(id);
        model.addAttribute("moneyTransaction", moneyTransaction);
        return "moneyTransactions/edit";
    }
}
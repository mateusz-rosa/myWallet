package com.mywallet.controllers;

import com.mywallet.domain.Category;
import com.mywallet.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mateusz on 2017-01-08.
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        categoryRepository.delete(id);
        return new ModelAndView("redirect:/categories");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newCategory() {
        return "categories/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("nameOfCategory") String nameOfCategory) {
        categoryRepository.save(new Category(nameOfCategory));
        return new ModelAndView("redirect:/categories");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("nameOfCategory") String nameOfCategory) {
        Category category = categoryRepository.findOne(id);
        category.setNameOfCategory(nameOfCategory);
        categoryRepository.save(category);
        return new ModelAndView("redirect:/categories");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        Category category = categoryRepository.findOne(id);
        model.addAttribute("category", category);
        return "categories/edit";
    }

}

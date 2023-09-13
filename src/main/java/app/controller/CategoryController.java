package app.controller;

import app.dao.CategoryDao;
import app.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Category> categoryList = categoryDao.findAll();
        model.addAttribute("categoryList", categoryList);
        return "categoryList";
    }

    @GetMapping("/add")
    public String addCategoryView(Model model) {
        model.addAttribute("category", new Category());
        return "add-category-view";
    }

    @PostMapping("/add")
    public String addCategory(Category category){
        categoryDao.save(category);
        return "redirect:/categories/list";
    }
    @GetMapping("/delete")
    public String deleteCategoryView(Model model, @RequestParam Long id){
        model.addAttribute("category", categoryDao.findById(id));
        return "delete-category-view";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "redirect:/categories/list";
    }

    @GetMapping("/update")
    public String updateCategoryView(Model model, @RequestParam Long id) {
        model.addAttribute("category", categoryDao.findById(id));
        return "update-category-view";
    }

    @PostMapping("/update")
    public String updateCategory(Category category) {
        categoryDao.update(category);
        return "redirect:/categories/list";
    }

}
package app.controller;

import app.dao.CategoryDao;
import app.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("get")
    public String get(@RequestParam Long id) {
        Category category = categoryDao.findById(id);
        return category.toString();
    }

    @PostMapping("create")
    public String create(@RequestParam String description, @RequestParam String name) {
        Category category = new Category();
        category.setDescription(description);
        category.setName(name);
        categoryDao.save(category);
        return category.toString();
    }

    @PostMapping("update")
    public String update(@RequestParam Long id, @RequestParam String description, @RequestParam String name) {
        Category category = categoryDao.findById(id);
        category.setDescription(description);
        category.setName(name);
        categoryDao.update(category);
        return category.toString();
    }

    @PostMapping("delete")
    public String delete(@RequestParam Long id) {
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return category.toString();
    }

    @GetMapping
    public String findAll(){
        List<Category> allCategories=categoryDao.findAll();
        return allCategories.toString();
    }
}
package app.controller;


import app.dao.AuthorDao;
import app.entity.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("authors")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String authorsListView(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authorsList";
    }

    @GetMapping("/add")
    public String addAuthorView(Model model) {
        model.addAttribute("author", new Author());
        return "add-author-view";
    }

    @PostMapping("/add")
    public String addAuthor(Author author) {
        authorDao.save(author);
        return "redirect:/authors/list";
    }

    @PostMapping("/delete")
    public String deleteAuthor(@RequestParam Long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/authors/list";
    }

    @GetMapping("/update")
    public String updateAuthorView(Model model, @RequestParam Long id){
        model.addAttribute("author", authorDao.findById(id));
        return "update-author-view";

    }
    @PostMapping("/update")
    public String updateAuthor(Author author) {
        authorDao.update(author);
        return "redirect:/authors/list";
    }
}

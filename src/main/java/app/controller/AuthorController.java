package app.controller;


import app.dao.AuthorDao;
import app.entity.Author;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("get")
    public String get(@RequestParam Long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @PostMapping("create")
    public String create(@RequestParam String firstName, @RequestParam String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.save(author);
        return author.toString();
    }

    @PostMapping("update")
    public String update(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName) {
            Author author = authorDao.findById(id);
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorDao.update(author);
            return author.toString();
    }
    @PostMapping("delete")
    public String delete(@RequestParam Long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return author.toString();
    }

    @GetMapping
    public String findAll(){
        List<Author> allAuthors = authorDao.findAll();
        return allAuthors.toString();
    }


}

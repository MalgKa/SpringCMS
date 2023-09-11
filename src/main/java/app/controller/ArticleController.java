package app.controller;


import app.dao.ArticleDao;
import app.dao.AuthorDao;
import app.dao.CategoryDao;
import app.entity.Article;
import app.entity.Author;
import app.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("articles")
public class ArticleController {
    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;


    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("get")
    public String get(@RequestParam Long id) {
        Article article = articleDao.findById(id);
        return article.toString();
    }

    @PostMapping("create")
    public String create(@RequestParam String title, @RequestParam String content,
                         @RequestParam Long authorId, @RequestParam List<Long> categoriesIds) {
        Article article = new Article();

        Author author = authorDao.findById(authorId);
        article.setAuthor(author);

        for (Long categoryId : categoriesIds) {
            Category category = categoryDao.findById(categoryId);
            article.getCategories().add(category);
        }

        article.setTitle(title);
        article.setContent(content);

        articleDao.save(article);
        return article.toString();

    }

    @PostMapping("update")
    public String update(@RequestParam Long articleId, @RequestParam String title,
                         @RequestParam String content, @RequestParam Long authorId,
                         @RequestParam List<Long> categoriesIds) {
        Article article = articleDao.findById(articleId);
        article.setTitle(title);
        article.setContent(content);

        Author author = authorDao.findById(authorId);
        article.setAuthor(author);

        for (Long categoryId : categoriesIds) {
            Category category = categoryDao.findById(categoryId);
            article.getCategories().add(category);
        }
        articleDao.update(article);
        return article.toString();
    }
    @PostMapping("delete")
    public String delete(@RequestParam Long id) {
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return article.toString();
    }

    @GetMapping()
    public String findAll(){
        List<Article> allArticles = articleDao.findAll();
        return allArticles.toString();
    }


}

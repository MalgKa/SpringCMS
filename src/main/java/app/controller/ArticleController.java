package app.controller;


import app.dao.ArticleDao;
import app.dao.AuthorDao;
import app.dao.CategoryDao;
import app.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
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

    @GetMapping("/list")
    public String articleListView(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "articlesList";
    }

    @GetMapping("/add")
    public String addArticleView(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("authorsList", authorDao.findAll());
        model.addAttribute("categoryList", categoryDao.findAll());
        return "add-article-view";
    }

    @PostMapping("/add")
    public String addArticle(Article article) {
        articleDao.save(article);
        return "redirect:/articles/list";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Long id) {
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/articles/list";
    }


    @GetMapping("update")
    public String updateArticleView(Model model, @RequestParam Long id){
        model.addAttribute("article", articleDao.findById(id));
        model.addAttribute("authorsList", authorDao.findAll());
        model.addAttribute("categoryList", categoryDao.findAll());
        return "update-article-view";
    }


    @PostMapping("update")
    public String update(Article article) {
        articleDao.update(article);
        return "redirect:/articles/list";
    }
}

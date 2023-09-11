package app.controller;

import app.dao.ArticleDao;
import app.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/")
public class HomePageController {
    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping
    public String findLast5(){
        List<Article> last5Articles = articleDao.last5();
        //można użyć DateTimeFormatter, żeby sposób wyświetlania daty np:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        last5Articles.forEach(a->log.info(a.toString()));
        return last5Articles.stream()
                .map(a->String.format("title: %s, content: %s, created at: %s",a.getTitle(),a.getContent(),a.getCreated().format(formatter)))
                .collect(Collectors.joining("\n"));
    }
}

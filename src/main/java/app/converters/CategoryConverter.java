package app.converters;

import app.dao.CategoryDao;
import app.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String source) {
        Long id = Long.parseLong(source);
        return categoryDao.findById(id);
    }
}

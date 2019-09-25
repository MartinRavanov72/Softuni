package spring_excr.services;

import spring_excr.models.Category;

import java.util.List;

public interface CategoryService {
    void saveCategoryIntoDb(Category category);

    void saveCategoryIntoDb(List<Category> categories);
}

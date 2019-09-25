package spring_excr.services;

import spring_excr.dtos.export.CategoryView;
import spring_excr.models.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> getAll();

    Category getById(int rndInt);

    List<CategoryView> getCategoriesByProductsCount();
}
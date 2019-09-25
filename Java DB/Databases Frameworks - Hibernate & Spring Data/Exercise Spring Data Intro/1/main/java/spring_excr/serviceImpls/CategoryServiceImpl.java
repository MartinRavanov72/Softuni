package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_excr.models.Category;
import spring_excr.repositories.CategoryRepository;
import spring_excr.services.CategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveCategoryIntoDb(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void saveCategoryIntoDb(List<Category> categories) {
        this.categoryRepository.save(categories);
    }
}

package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_excr.dtos.export.CategoryView;
import spring_excr.models.Category;
import spring_excr.repositories.CategoryRepository;
import spring_excr.services.CategoryService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int rndInt) {
        return this.categoryRepository.findById(rndInt);
    }

    @Override
    public List<CategoryView> getCategoriesByProductsCount() {
        List<Object[]> list = this.categoryRepository.getCategoriesByProductsCount();
        List<CategoryView> categoryViews = new ArrayList<>();
        for (Object[] objArr : list) {
            CategoryView categoryView = new CategoryView();
            categoryView.setName((String)objArr[0]);
            categoryView.setProductsCount((Integer)objArr[1]);
            categoryView.setAveragePrice(BigDecimal.valueOf((Double)objArr[2]));
            categoryView.setTotalRevenue((BigDecimal)objArr[3]);
            categoryViews.add(categoryView);
        }
        return categoryViews;
    }
}
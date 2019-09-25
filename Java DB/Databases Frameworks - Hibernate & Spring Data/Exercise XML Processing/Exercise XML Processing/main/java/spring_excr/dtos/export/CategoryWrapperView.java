package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
public class CategoryWrapperView {
    private List<CategoryView> categories;

    public CategoryWrapperView() {
    }

    @XmlElement(name = "category")
    public List<CategoryView> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryView> categories) {
        this.categories = categories;
    }
}
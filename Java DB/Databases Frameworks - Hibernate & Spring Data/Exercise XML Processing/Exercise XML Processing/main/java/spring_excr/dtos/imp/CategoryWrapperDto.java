package spring_excr.dtos.imp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "categories")
public class CategoryWrapperDto {

    private List<CategoryDto> categories;

    public CategoryWrapperDto() {
        this.categories = new ArrayList<>();
    }

    @XmlElement(name = "category")
    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
}

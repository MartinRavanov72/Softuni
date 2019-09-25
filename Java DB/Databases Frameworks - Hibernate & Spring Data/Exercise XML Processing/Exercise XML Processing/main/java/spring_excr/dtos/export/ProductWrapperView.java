package spring_excr.dtos.export;

import spring_excr.dtos.imp.ProductDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "products")
public class ProductWrapperView {
    private List<ProductView> products;

    public ProductWrapperView() {
        this.products = new ArrayList<>();
    }

    @XmlElement(name = "product")
    public List<ProductView> getProducts() {
        return products;
    }

    public void setProducts(List<ProductView> products) {
        this.products = products;
    }
}

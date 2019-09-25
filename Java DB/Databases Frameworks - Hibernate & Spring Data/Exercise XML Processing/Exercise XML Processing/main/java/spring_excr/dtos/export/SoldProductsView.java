package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sold-products")
public class SoldProductsView {
    private int count;

    private List<ProductNamePriceView> products;

    public SoldProductsView() {
        this.products = new ArrayList<>();
    }

    @XmlAttribute
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name = "product")
    public List<ProductNamePriceView> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNamePriceView> products) {
        this.products = products;
    }
}

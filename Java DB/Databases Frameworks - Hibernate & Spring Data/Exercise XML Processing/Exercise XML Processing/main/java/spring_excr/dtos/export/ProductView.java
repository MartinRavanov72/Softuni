package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
public class ProductView {

    private String name;

    private BigDecimal price;

    private String sellerFirstNameAndLastName;

    public ProductView() {
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlAttribute(name = "seller")
    public String getSellerFirstNameAndLastName() {
        return sellerFirstNameAndLastName;
    }

    public void setSellerFirstNameAndLastName(String sellerName) {
        this.sellerFirstNameAndLastName = sellerName;
    }
}

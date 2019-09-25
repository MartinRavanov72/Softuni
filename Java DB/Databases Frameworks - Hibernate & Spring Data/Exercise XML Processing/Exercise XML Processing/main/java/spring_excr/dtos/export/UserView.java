package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
public class UserView {
    private String firstName;

    private String lastName;

    private List<SoldProductView> soldProducts;

    public UserView() {
        this.soldProducts = new ArrayList<>();
    }

    @XmlAttribute(name = "first-name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute(name = "last-name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    public List<SoldProductView> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductView> soldProducts) {
        this.soldProducts = soldProducts;
    }
}


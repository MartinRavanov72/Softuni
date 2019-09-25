package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserNameAgeView implements Comparable<UserNameAgeView> {

    private String firstName;

    private String lastName;

    private int age;

    private SoldProductsView soldProducts;

    public UserNameAgeView() {
    }

    @XmlAttribute(name = "first-name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute(name = "last-name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlAttribute(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age == 0) {

        } else {
            this.age = age;
        }
    }

    @XmlElement(name = "sold-products")
    public SoldProductsView getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsView soldProducts) {
        this.soldProducts = soldProducts;
    }

    @Override
    public int compareTo(UserNameAgeView o) {
        int comp = Integer.compare(o.getSoldProducts().getCount(), this.getSoldProducts().getCount());
        if (comp == 0) {
            comp = this.getLastName().compareTo(o.getLastName());
        }
        return comp;
    }
}

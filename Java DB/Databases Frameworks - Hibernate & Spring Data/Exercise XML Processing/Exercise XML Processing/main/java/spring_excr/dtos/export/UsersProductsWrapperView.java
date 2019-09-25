package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;
import java.util.TreeSet;

@XmlRootElement(name = "users")
public class UsersProductsWrapperView {

    private int usersCount;

    private Set<UserNameAgeView> users;

    public UsersProductsWrapperView() {
        this.users = new TreeSet<>();
    }

    @XmlAttribute(name = "count")
    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    @XmlElement(name = "user")
    public Set<UserNameAgeView> getUsers() {
        return users;
    }

    public void setUsers(Set<UserNameAgeView> users) {
        this.users = users;
    }
}

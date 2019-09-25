package spring_excr.dtos.export;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
public class UserWrapperView {
    private List<UserView> users;

    public UserWrapperView() {
    }

    @XmlElement(name = "user")
    public List<UserView> getUsers() {
        return users;
    }

    public void setUsers(List<UserView> users) {
        this.users = users;
    }
}

package spring_excr.dtos.imp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class UserWrapperDto  {

    private List<UserDto> users;

    public UserWrapperDto() {
        this.users = new ArrayList<>();
    }

    @XmlElement(name = "user")
    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}

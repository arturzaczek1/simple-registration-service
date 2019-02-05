package User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String mail;
    private String password;
    private String name;
    private String lastName;
}

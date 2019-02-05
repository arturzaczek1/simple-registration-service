package User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ToString
public class User extends BaseEntity {

    private String mail;
    @Column (length = 256)
    private String passwordHash;
    private String name;
    private String lastName;

}

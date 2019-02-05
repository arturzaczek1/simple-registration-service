import User.UserRegistrationService;
import org.junit.jupiter.api.Test;
import User.*;

public class UserTest {
    UserRegistrationService userRegistrationService = new UserRegistrationService();

    @Test
    public void test() {
        UserDTO userDTO = new UserDTO();
        userDTO.setMail("darek.lewandowski@o2.pl");
        userDTO.setName("Darisz");
        userDTO.setLastName("Lewandowski");
        userDTO.setPassword("darek01");
        userRegistrationService.addNewUser(userDTO);
    }

    @Test
    public void test2() {
        String mail = "darek.lewandowski@o2.pl";
        System.out.println(userRegistrationService.checkIfUserExist(mail));
    }

}

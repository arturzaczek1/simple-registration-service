package User;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

public class UserRegistrationService {

    public boolean checkIfUserExist(String mail) {
        return UserDAO.getInstance().checkIfUserExist(mail.trim());
    }

    public void addNewUser(UserDTO userDTO) {
        UserDAO.getInstance().saveNewUser(rewriteUserDTOtoUser(userDTO));
    }

    private User rewriteUserDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName().trim());
        user.setLastName(userDTO.getLastName().trim());
        user.setMail(userDTO.getMail().trim());
        user.setPasswordHash(DigestUtils.sha512Hex(userDTO.getPassword().trim()));

        return user;
    }

}

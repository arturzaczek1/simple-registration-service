package User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserValidationService {


    public Map<String, String> validateUser(UserDTO userDTO) {
        Map<String, String> errorsMap = new HashMap<String, String>();
        if (userDTO.getName() == null || !userDTO.getName().trim().matches("[A-Z][a-z]+")) {
            errorsMap.put("nameErr", "Name should contain at least 3 letters starts with capital letter");
        }
        if (userDTO.getLastName() == null || !userDTO.getLastName().trim().matches("[A-Z][a-z]")) {
            errorsMap.put("lastNameErr", "Last Name should contain at least 2 letters starts with capital letter");
        }
        if (userDTO.getMail() == null || !userDTO.getMail().trim().matches("\\w+[@]{1}\\w+[.]{1}\\w{1,3}$")) {
            errorsMap.put("emailErr", "Email example: example@gmail.com");
        }
        if (userDTO.getPassword() == null || !userDTO.getPassword().trim().matches("^(?=.*\\d).{4,8}$")) {
            errorsMap.put("passwordErr", "Password supposed to contain digits and letters at least 4 characters, maximum 8");
        }
        return errorsMap;
    }

    //    only for tests
    public List<String> validateUserreturnList(UserDTO userDTO) {
        List<String> errorsList = new ArrayList<String>();
        if (userDTO.getName() == null || !userDTO.getName().trim().matches("[A-Z][a-z]+$")) {
            errorsList.add("Name should contain at least 3 letters starts with capital letter");
        }
        if (userDTO.getLastName() == null || !userDTO.getLastName().trim().matches("[A-Z][a-z]*$")) {
            errorsList.add("Last Name should contain at least 2 letters starts with capital letter");
        }
        if (userDTO.getMail() == null || !userDTO.getMail().trim().matches("\\w+[@]{1}\\w+[.]{1}\\w{1,3}$")) {
            errorsList.add("Email example: example@gmail.com");
        }
        if (userDTO.getPassword() == null || !userDTO.getPassword().trim().matches("^(?=.*\\d).{4,8}$")) {
            errorsList.add("Password supposed to contain digits and letters at least 4 characters, maximum 8");
        }
        return errorsList;
    }
}

import com.UserInfo.User;
 
public class RegistrationBO {
    public void validate(User user) throws BusinessException {
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty() ||
            user.getLastName() == null || user.getLastName().trim().isEmpty() ||
            user.getCountry() == null || user.getCountry().isEmpty() ||
            user.getGender() == null || user.getGender().isEmpty()) {
            throw new BusinessException("All fields except languages are mandatory.");
        }
    }
}
 
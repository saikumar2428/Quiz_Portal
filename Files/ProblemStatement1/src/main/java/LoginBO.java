public class LoginBO {
	public boolean validate(String username,String password) throws BusinessException {
		if(username==null || username.isEmpty() || password==null ||  password.isEmpty()) {
			throw new BusinessException("Username and password cannot be empty");
		}
		LoginDAO dao=new LoginDAO();
		return dao.checkCredentials(username,password);
	}
 
}
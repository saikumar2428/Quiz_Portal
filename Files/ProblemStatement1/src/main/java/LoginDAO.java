import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class LoginDAO {
	public boolean checkCredentials(String username,String password) throws BusinessException{
		try(Connection con=DatabaseConnection.getConnection()){
			User uobj=new User();
			int count=0;
			String sql="Select * from user where username=? and password=?";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				count++;
			}
			if(count>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException | ClassNotFoundException e) {
			throw new BusinessException("Invalid username/password");
		}
	}
}
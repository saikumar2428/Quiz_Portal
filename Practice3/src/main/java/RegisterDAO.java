import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import com.UserInfo.User;
 
import java.sql.*;
public class RegisterDAO {
    private static final String url = "jdbc:mysql://localhost:3306/mphasis";
    private static final String userName = "root";
    private static final String password = "Password@12";
 
    public int save(User user) throws SQLException {
        int registrationId = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
 
        try {
            // Establish connection
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
 
            // SQL query to insert user data
            String sql = "INSERT INTO friends(first_name, last_name, country, languages, gender) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
 
            // Set parameters
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, String.join(",", user.getLanguages()));
            preparedStatement.setString(5, user.getGender());
 
            // Execute update
            int affectedRows = preparedStatement.executeUpdate();          	
            if (affectedRows > 0) {
                // Retrieve the generated registration ID
                try ( ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        registrationId = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error inserting user data into database", e);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            // Close resources
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
 
        return registrationId;
    }
}
 
 
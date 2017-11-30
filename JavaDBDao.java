package goodman.james.powertothepeople;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jamesgoodman on 28/11/17.
 */

public class JavaDBDao {

    private String email;



    public Boolean checkEmailInDB(String email) throws SQLException {
        Connection conn;
        SQLConnection sqlConnection = new SQLConnection();
        conn = sqlConnection.run();

        final String queryCheck = "SELECT count(*)from signUpTable WHERE email = ?";
        final PreparedStatement ps = conn.prepareStatement(queryCheck);
        ps.setString(1,email);
        final ResultSet resultSet = ps.executeQuery();
        if(resultSet == null) {
            System.out.println("what is in the result set *** " + resultSet.toString());
            //final int count = resultSet.getInt(1);
            //something there,already registered so look to sign them in
            conn.close();
            return true;

        }
        conn.close();
        return false;
    }

   public void insertObjectIntoDatabase(Type type){
       //get a connection
       Connection conn;
       SQLConnection sqlConnection = new SQLConnection();
       conn = sqlConnection.run();

       if(type.equals(bizSignUpDAO.class)){

       }else{

       }
   }
}

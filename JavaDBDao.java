package goodman.james.powertothepeople;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jamesgoodman on 28/11/17.
 */

public class JavaDBDao {

    private String email;



    public Boolean checkBizEmailInDB(String email) throws SQLException {
        Connection conn;
        SQLConnection sqlConnection = new SQLConnection();
        conn = sqlConnection.run();

        final String queryCheck = "SELECT count(*)from signUpTableBiz WHERE email = ?";
        final PreparedStatement ps = conn.prepareStatement(queryCheck);
        ps.setString(1,email);
        final ResultSet resultSet = ps.executeQuery();
        if(resultSet == null) {

            //final int count = resultSet.getInt(1);
            //something there,already registered so look to sign them in
            conn.close();
            return true;

        }
        conn.close();
        return false;
    }

    public Boolean checkCusEmailInDB(String email) throws SQLException {
        Connection conn;
        SQLConnection sqlConnection = new SQLConnection();
        conn = sqlConnection.run();

        final String queryCheck = "SELECT count(*)from signUpTableCus WHERE email = ?";
        final PreparedStatement ps = conn.prepareStatement(queryCheck);
        ps.setString(1,email);
        final ResultSet resultSet = ps.executeQuery();
        if(resultSet == null) {

            //something there,already registered so look to sign them in
            conn.close();
            return true;

        }
        conn.close();
        return false;
    }


   public void insertObjectIntoDatabase(BizSignUpDAO bizSignUpDAO) throws SQLException{

//
//       java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//       java.sql.Time time = new java.sql.Time(Calendar.getInstance().getTime().getTime());
       Calendar calendar = Calendar.getInstance();
       java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());

       //get a connection
       Connection conn;
       SQLConnection sqlConnection = new SQLConnection();
       conn = sqlConnection.run();

         if(conn != null){

         String query = "INSERT INTO signUpTableBiz (bizUsername, email, password,create_time )"
                 + "values (?,?,?,?)";

           PreparedStatement preparedStmt = conn.prepareStatement(query);
           preparedStmt.setString (1,bizSignUpDAO.bizUsername );
           preparedStmt.setString (2, bizSignUpDAO.email);
           preparedStmt.setString  (3, bizSignUpDAO.password);
           preparedStmt.setTimestamp  (4, ourJavaTimestampObject,calendar);


           // execute the preparedstatement
           preparedStmt.execute();

           conn.close();

       }else{
           System.out.println("Didnt insert into the database - sad times :(");

       }
   }
}

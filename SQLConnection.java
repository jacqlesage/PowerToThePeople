package goodman.james.powertothepeople;

import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jamesgoodman on 23/11/17.
 */

public class SQLConnection
{


    public  Connection run() {
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";



        try {
           Class.forName(driver).newInstance();
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://liquidflameit.co.nz/liquidfl_goodman", "liquidfl_goodman", "Goodman01");

            //if(con != null) {
//                System.out.println(con.toString()+ " ###### create ");
//
//                Statement stmt = con.createStatement();
//
//                String sql = "CREATE TABLE REGISTRATION " +
//                        "(id INTEGER not NULL, " +
//                        " first VARCHAR(255), " +
//                        " last VARCHAR(255), " +
//                        " age INTEGER, " +
//                        " PRIMARY KEY ( id ))";
//
//                stmt.executeUpdate(sql);
//                System.out.println("Created table in given database...");


           // }



            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return con;

    }

}
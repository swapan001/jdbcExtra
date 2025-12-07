package batchexecution;
import org.postgresql.Driver;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Batch {

    //batch execution is used to carry a group of sql query from our java program to database
    /*
    * Batch execution we will add multiple queries in one batch and we will execute all the queries together.
    *
    * To achieve batch execution we use method like addBatch() and executeBatch().
    * */
static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=root";
    public static void main(String[] args)throws SQLException {
        //step -1
        Driver driver=new Driver();
        DriverManager.registerDriver(driver);

        //step-2
        Connection connection= DriverManager.getConnection(url);
        //step-3
        Statement statement=connection.createStatement();

        String query1="insert into student values ('112','Arman Mallik','mallikarman999@gmail.com',12)";
        String query2="insert into student values ('115','Suman Mal','suman223@gmail.com',11)";
        String query3="insert into student values ('120`','Puja Roy','roypuja559@gmail.com',10)";

        //create queries and add them to a batch

        statement.addBatch(query1);
        statement.addBatch(query2);
        statement.addBatch(query3);

        //step 4

        statement.executeBatch();
        System.out.println("Success 123");

    }
}

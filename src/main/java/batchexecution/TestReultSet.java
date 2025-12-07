package batchexecution;

import org.postgresql.Driver;

import java.sql.*;

import static batchexecution.Batch.url;

public class TestReultSet {

    public static void main(String[] args) throws SQLException {
        //step -1
        Driver driver=new Driver();
        DriverManager.registerDriver(driver);

        //step-2
        Connection connection= DriverManager.getConnection(url);
        //step-3

        // inside createStatement(args) the args is used to
        // Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        //create query
        String query="select sid,name from student";
        //step-4

//       ResultSet resultSet=statement.executeQuery(query);

        ResultSet resultSet=statement.executeQuery(query);
        int i=0;
        while(resultSet.next()){
            ++i;
            System.out.println(i+" Name: "+resultSet.getString(2));

            if(resultSet.getString(2).equals("Aryaaan Roy")){
                resultSet.updateString(2,"Ankan Chatterjee");
                resultSet.updateRow();
            }


        }
        System.out.println("--------------------------------------------------------");

        while(resultSet.previous()){
            --i;
            System.out.println(i+" Name: "+resultSet.getString(2));

        }

    }
}

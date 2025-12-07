package batchexecution;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

import static batchexecution.TestProcedure.url;
public class TestImage2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //S-1
        Class.forName("org.postgresql.Driver");
        //S-2
        Connection connection= DriverManager.getConnection(url);
        //S-3
        String query="select ename,photo from employee where empid=?";

        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,1);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            String ename=resultSet.getString("ename");
            byte [] img=resultSet.getBytes("photo");

            FileOutputStream fileOutputStream=new FileOutputStream("D:/Advancejava/imgfile_from_database/"+ename+".jpg");

            fileOutputStream.write(img);
            System.out.println("Success!!!!");

        }
        //S-4

    }
}

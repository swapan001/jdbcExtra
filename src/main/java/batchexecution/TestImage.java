package batchexecution;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static batchexecution.TestProcedure.url;
public class TestImage {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url);

        String query="update employee set photo=? where empid=?";

        File file=new File("C:/Users/2001s/Downloads/jukuKaku.jpeg");
        FileInputStream fileInputStream=new FileInputStream(file);

        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setBinaryStream(1,fileInputStream);
        preparedStatement.setInt(2,1);


        preparedStatement.execute();

        preparedStatement.execute();

        System.out.println("Sucess>>>");

    }
}

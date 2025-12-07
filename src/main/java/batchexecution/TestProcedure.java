package batchexecution;

import java.sql.*;

public class TestProcedure {
    static String url="jdbc:postgresql://localhost:5432/company?user=postgres&password=root";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //step-1
        Class.forName("org.postgresql.Driver");
        //step-2
        Connection connection= DriverManager.getConnection(url);

        //step-3

        String query="call update_sal(?,?)";

        CallableStatement callableStatement=connection.prepareCall(query);
        callableStatement.setInt(1,11);
        callableStatement.setDouble(2,29000);
        callableStatement.execute();

        System.out.println("Success");

    }
}

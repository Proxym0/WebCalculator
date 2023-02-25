package by.tms.storage;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.tms.storage.Constanta.*;

public class JDBCOperationStorage implements OperationStorage {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";

    public void save(Operation operation) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into operations values (default,?,?,?,?) ");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setDouble(3, operation.getResult());
            preparedStatement.setString(4, operation.getType());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Operation> findAll() {
        List <Operation> operations=new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery("select * from operations");
            while (res.next()) {
                double num1 = res.getDouble("num1");
                double num2 = res.getDouble("num2");
                double result = res.getDouble("result");
                String type=res.getString("operation_type");
                Operation operation = new Operation(num1, num2, result,type);
                operations.add(operation);


            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return operations;
    }
}

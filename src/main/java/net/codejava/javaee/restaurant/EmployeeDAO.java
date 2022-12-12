package net.codejava.javaee.restaurant;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class EmployeeDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public EmployeeDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (fullName, birthDate, position) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, employee.getFullName());
        statement.setDate(2, Date.valueOf(employee.getBirthDate()));
        statement.setString(3, employee.getPosition());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Employee> listAllEmployees() throws SQLException {
        List<Employee> listEmployee = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fullName = resultSet.getString("fullName");
            LocalDate birthDate = LocalDate.parse(resultSet.getString("birthDate"));
            String position = resultSet.getString("position");

            Employee employee = new Employee(id, fullName, birthDate, position);
            listEmployee.add(employee);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listEmployee;
    }

    public boolean deleteEmployee(Employee employee) throws SQLException {
        String sql = "DELETE FROM employee where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, employee.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET fullName = ?, birthDate = ?, position = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, employee.getFullName());
        statement.setDate(2, Date.valueOf(employee.getBirthDate()));
        statement.setString(3, employee.getPosition());
        statement.setInt(4, employee.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Employee getEmployee(int id) throws SQLException {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String fullName = resultSet.getString("fullName");
            LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();
            String position = resultSet.getString("position");

            employee = new Employee(id, fullName, birthDate, position);
        }

        resultSet.close();
        statement.close();

        return employee;
    }
}
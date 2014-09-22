import java.util.*;
import java.sql.*;

public class CustomerDB implements CustomerDAO
{
    private Connection getConnection()
    {
        Connection connection = null;
        try
        {
            // if necessary, set the home directory for Derby
            String dbDirectory = "C:/Users/MAX-Student/Desktop/Books/java/db";
            System.setProperty("derby.system.home", dbDirectory);

            // set the db url, username, and password
            String url = "jdbc:derby:MurachDB";
            String username = "";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
			return connection;
        }
        catch(SQLException e)
        {
            System.err.println(e);
			return null;
        }
    }

    public ArrayList<Customer> getCustomers()
    {
        String sql = "SELECT EmailAddress, FirstName, LastName "
                   + "FROM Customers ORDER BY EmailAddress ASC";        
        ArrayList<Customer> customers = new ArrayList<>();
        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                String emailAddress = rs.getString("EmailAddress");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");

                Customer c = new Customer(emailAddress, firstName, lastName);
                customers.add(c);
            }
            return customers;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public Customer getCustomer(String emailAddress)
    {
        String sql =
            "SELECT EmailAddress, FirstName, LastName "
                   + "FROM Customers " +
            "WHERE EmailAddress = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, emailAddress);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                Customer c = new Customer(emailAddress, firstName, lastName);
                rs.close();
                return c;
            }
            else
            {
                rs.close();
                return null;
            }
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }

    public boolean addCustomer(Customer c)
    {
        String sql =
            "INSERT INTO Customers (EmailAddress, FirstName, LastName) " +
            "VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, c.getEmailAddress());
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }

    public boolean deleteCustomer(Customer c)
    {
        String sql = "DELETE FROM Customers " +
                     "WHERE EmailAddress = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, c.getEmailAddress());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }

    public boolean updateCustomer(Customer c)
    {
        String sql = "UPDATE Customers SET " +
                         "FirstName = ?, " +
                         "LastName = ? " +
                     "WHERE EmailAddress = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmailAddress());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }

	

	
}
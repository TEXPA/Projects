public class DAOFactory
{
    // this method maps the ProductDAO interface
    // to the appropriate data storage mechanism
    public static CustomerDAO getCustomerDAO()
    {
        CustomerDAO cDAO = new CustomerDB();
        return cDAO;
    }
}
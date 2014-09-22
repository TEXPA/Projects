
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.stream.*;  // StAX API

public class CustomerXMLFile implements CustomerDAO
{
    private Path customersPath = null;
    private ArrayList<Customer> customers = null;

    public CustomerXMLFile()
    {
        customersPath = Paths.get("customer.xml");
        customers = this.getCustomers();
    }
    private boolean saveCustomers()
    {
        // create the XMLOutputFactory object
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        try
        {
            // create XMLStreamWriter object
            FileWriter fileWriter =
                new FileWriter(customersPath.toFile());
            XMLStreamWriter writer =
                outputFactory.createXMLStreamWriter(fileWriter);

            //write the products to the file
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Customers");
            for (Customer c: customers)
            {
                writer.writeStartElement("Customer");
                writer.writeAttribute("Email", c.getEmail());
             
                writer.writeStartElement("FirstName");
                writer.writeCharacters(c.getFirstName());
                writer.writeEndElement();

                writer.writeStartElement("LastName");
                writer.writeCharacters(c.getLastName());
                writer.writeEndElement();

                writer.writeEndElement();
                
            }
            writer.writeEndElement();
            writer.flush();
            writer.close();
        }
        catch (IOException | XMLStreamException e)
        {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public ArrayList<Customer> getCustomers()
    {
        // if the XML file has already been read, don't read it again
        if (customers != null)
            return customers;        

        customers = new ArrayList<>();        
        Customer c = null;        
        if (Files.exists(customersPath))  // prevent the FileNotFoundException
        {
            // create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try
            {
                // create a XMLStreamReader object
                FileReader fileReader =
                    new FileReader(customersPath.toFile());
                XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(fileReader);

                // read the products from the file
                while (reader.hasNext())
                {
                    int eventType = reader.getEventType();
                    switch (eventType)
                    {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Customer"))
                            {
                                c = new Customer();
                                String email = reader.getAttributeValue(0);
                                c.setEmail(email);
                            }
                            if (elementName.equals("FirstName"))
                            {
                                String firstName = reader.getElementText();
                                c.setFirstName(firstName);
                            }
                            if (elementName.equals("LastName"))
                            {
                            	String lastName = reader.getElementText();
                                c.setLastName(lastName);
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Customer"))
                            {
                                customers.add(c);
                            }
                            break;
                        default:
                            break;
                    }
                    reader.next();
                }
            }
            catch (IOException | XMLStreamException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return customers;
    }

    public Customer getCustomer(String email)
    {
        for (Customer c : customers)
        {
            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }

    public boolean addCustomer(Customer c)
    {
        customers.add(c);
        return this.saveCustomers();
    }

    public boolean deleteCustomer(Customer c)
    {
        customers.remove(c);
        return this.saveCustomers();
    }

    public boolean updateCustomer(Customer newCustomer)
    {
        // get the old product and remove it
        Customer oldCustomer = this.getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated product
        customers.add(i, newCustomer);

        return this.saveCustomers();
    }
}
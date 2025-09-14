package hotelpkg;
import java.util.*;
public class Hotel 
{
    public HashMap<Integer, Customer> customerData = new HashMap<>();

    public void addcustomer(Customer customer) 
    {
        customerData.put(customer.room, customer);
    }

    public Customer customerdetails(int room) 
    {
        return customerData.get(room);
    }

    public void removecustomer(int room) 
    {
        customerData.remove(room);
    }

    public boolean roomavailable(int room) 
    {
        return !customerData.containsKey(room);
    }
}


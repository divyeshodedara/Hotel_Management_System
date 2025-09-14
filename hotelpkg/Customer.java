package hotelpkg;
import java.util.*;
public class Customer 
{
    public String name;
    public int room;
    public String rtype;
    public int days;
    public ArrayList<String> services = new ArrayList<>();

    public Customer(String name, int room, String rtype, int days) 
    {
        this.name = name;
        this.room = room;
        this.rtype = rtype;
        this.days = days;
    }
    public void addservice(String service) 
    {
        services.add(service);
    }

    public ArrayList<String> getservice() 
    {
        return services;
    }

    public int totalroomcharge() 
    {
        int rate;
        switch (rtype) {
            case "Standard" -> rate = 1200;
            case "Deluxe" -> rate = 2500;
            case "Suite" -> rate = 4000;
            default -> rate = 0;
        }
        return rate * days;
    }
}





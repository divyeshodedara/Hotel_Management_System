package hotelpkg;

public class member extends Customer 
{
    public member(String name, int room, String rtype, int days) 
    {
        super(name, room, rtype, days);
    }

    @Override
    public int totalroomcharge() 
    {
        int baseRate = super.totalroomcharge();
        return (int)(baseRate * 0.9);
    }
}
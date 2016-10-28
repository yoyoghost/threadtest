package proxy;

public class Buy implements AutoBuy
{
    
    public Buy()
    {
        super();
    }
    
    public void buy(int number)
    {
        System.out.println("the number of goods to buy is " + number);
    }
    
}
